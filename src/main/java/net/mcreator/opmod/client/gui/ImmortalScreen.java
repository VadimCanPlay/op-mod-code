
package net.mcreator.opmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.opmod.world.inventory.ImmortalMenu;
import net.mcreator.opmod.network.ImmortalButtonMessage;
import net.mcreator.opmod.OpModMod;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ImmortalScreen extends AbstractContainerScreen<ImmortalMenu> {
	private final static HashMap<String, Object> guistate = ImmortalMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_enable;
	Button button_disabled;
	Button button_op_yourself;
	Button button_get_gear;
	Button button_empty;

	public ImmortalScreen(ImmortalMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("op_mod:textures/screens/immortal.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.op_mod.immortal.label_immortality_switch"), 68, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.op_mod.immortal.label_please_click_once"), 45, 18, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.op_mod.immortal.label_immortal"), 122, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.op_mod.immortal.label_switch"), 132, 58, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_enable = Button.builder(Component.translatable("gui.op_mod.immortal.button_enable"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_button_0"), new ImmortalButtonMessage(0, x, y, z));
			}
		}).bounds(this.leftPos + 59, this.topPos + 35, 56, 20).build();
		guistate.put("button:button_enable", button_enable);
		this.addRenderableWidget(button_enable);
		button_disabled = Button.builder(Component.translatable("gui.op_mod.immortal.button_disabled"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_button_1"), new ImmortalButtonMessage(1, x, y, z));
			}
		}).bounds(this.leftPos + 53, this.topPos + 57, 67, 20).build();
		guistate.put("button:button_disabled", button_disabled);
		this.addRenderableWidget(button_disabled);
		button_op_yourself = Button.builder(Component.translatable("gui.op_mod.immortal.button_op_yourself"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_button_2"), new ImmortalButtonMessage(2, x, y, z));
			}
		}).bounds(this.leftPos + 44, this.topPos + 83, 87, 20).build();
		guistate.put("button:button_op_yourself", button_op_yourself);
		this.addRenderableWidget(button_op_yourself);
		button_get_gear = Button.builder(Component.translatable("gui.op_mod.immortal.button_get_gear"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_button_3"), new ImmortalButtonMessage(3, x, y, z));
			}
		}).bounds(this.leftPos + 54, this.topPos + 112, 66, 20).build();
		guistate.put("button:button_get_gear", button_get_gear);
		this.addRenderableWidget(button_get_gear);
		button_empty = Button.builder(Component.translatable("gui.op_mod.immortal.button_empty"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_button_4"), new ImmortalButtonMessage(4, x, y, z));
			}
		}).bounds(this.leftPos + 71, this.topPos + 140, 35, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
