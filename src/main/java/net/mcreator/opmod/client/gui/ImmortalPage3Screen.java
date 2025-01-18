
package net.mcreator.opmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.opmod.world.inventory.ImmortalPage3Menu;
import net.mcreator.opmod.network.ImmortalPage3ButtonMessage;
import net.mcreator.opmod.OpModMod;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ImmortalPage3Screen extends AbstractContainerScreen<ImmortalPage3Menu> {
	private final static HashMap<String, Object> guistate = ImmortalPage3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_survival;
	Button button_creative;
	Button button_adventure;
	Button button_spectator;

	public ImmortalPage3Screen(ImmortalPage3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("op_mod:textures/screens/immortal_page_3.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.op_mod.immortal_page_3.label_gamemode_changer"), 45, 11, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.op_mod.immortal_page_3.button_empty"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortalpage3_button_0"), new ImmortalPage3ButtonMessage(0, x, y, z));
			}
		}).bounds(this.leftPos + 68, this.topPos + 133, 35, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_survival = Button.builder(Component.translatable("gui.op_mod.immortal_page_3.button_survival"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortalpage3_button_1"), new ImmortalPage3ButtonMessage(1, x, y, z));
			}
		}).bounds(this.leftPos + 52, this.topPos + 29, 67, 20).build();
		guistate.put("button:button_survival", button_survival);
		this.addRenderableWidget(button_survival);
		button_creative = Button.builder(Component.translatable("gui.op_mod.immortal_page_3.button_creative"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortalpage3_button_2"), new ImmortalPage3ButtonMessage(2, x, y, z));
			}
		}).bounds(this.leftPos + 52, this.topPos + 51, 67, 20).build();
		guistate.put("button:button_creative", button_creative);
		this.addRenderableWidget(button_creative);
		button_adventure = Button.builder(Component.translatable("gui.op_mod.immortal_page_3.button_adventure"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortalpage3_button_3"), new ImmortalPage3ButtonMessage(3, x, y, z));
			}
		}).bounds(this.leftPos + 50, this.topPos + 73, 72, 20).build();
		guistate.put("button:button_adventure", button_adventure);
		this.addRenderableWidget(button_adventure);
		button_spectator = Button.builder(Component.translatable("gui.op_mod.immortal_page_3.button_spectator"), e -> {
			if (true) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortalpage3_button_4"), new ImmortalPage3ButtonMessage(4, x, y, z));
			}
		}).bounds(this.leftPos + 50, this.topPos + 96, 72, 20).build();
		guistate.put("button:button_spectator", button_spectator);
		this.addRenderableWidget(button_spectator);
	}
}
