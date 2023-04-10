package com.duzo.tutorialmod.screen;

import com.duzo.tutorialmod.TutorialMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractSlider;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.AbstractList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.client.gui.widget.Slider;

public class PlayerMonitorScreen extends Screen {

    private int imageWidth;
    private int imageHeight;
    private String current_texture;
    private Widget slider;
    private final ResourceLocation GUI = new ResourceLocation(TutorialMod.MOD_ID,"textures/gui/player_monitor_gui.png");
    public PlayerMonitorScreen(ITextComponent titleIn) {
        super(titleIn);
        this.imageHeight = 175;
        this.imageWidth = 176;
        this.current_texture = "head";
        slider = this.buttons.get(2);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        int i = (this.width - 168) / 2;
        int j = (this.height - 175) / 2;
        this.addButton(
                new Button(i+145, j+60, 20, 20,
                        new StringTextComponent(">"),
                        (button) -> pressRightButton()));
//        this.addButton(
//                new Button (i+5, j+60, 20, 20,
//                        new StringTextComponent("<"),
//                        (button) -> pressLeftButton()));
        this.addButton(
                new Button (i+54, j+120, 60, 20,
                        new StringTextComponent("SELECT"),
                        (button) -> System.out.println("select button")));
//        matrixStack.push();
        //matrixStack.pop();
        this.renderBackground(matrixStack);
        //this.renderLimbSelection(matrixStack);
        super.render(matrixStack, mouseX, mouseY,partialTicks);
    }
//    public void renderLimbSelection(MatrixStack matrixStack) {
//        matrixStack.push();
//        this.minecraft.getTextureManager().bindTexture(GUI);
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        int i = (this.width - 64);
//        int j = (this.height - 64);
//        matrixStack.scale(4f, 4f, 1f);
//        if (this.current_texture == "head") {
//            this.blit(matrixStack, i+82, j+9, 176, 0, 8, 8);
//        }
//        if (this.current_texture == "arm") {
//            this.blit(matrixStack, i+82, j+9, 176, 8, 4, 12);
//        }
//        if (this.current_texture == "leg") {
//            this.blit(matrixStack, i+82, j+9, 176, 20, 4, 12);
//        }
//        matrixStack.pop();
//    }



    @Override
    public void renderBackground(MatrixStack matrixStack) {
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.current_texture == "head") {
            this.blit(matrixStack, i+82, j+9, 176, 0, 8, 8);
        }
        if (this.current_texture == "arm") {
            this.blit(matrixStack, i+82, j+9, 176, 8, 4, 12);
        }
        if (this.current_texture == "leg") {
            this.blit(matrixStack, i+82, j+9, 176, 20, 4, 12);
        }
    }
    public void pressRightButton() {
        if (this.current_texture == "arm") {
            this.current_texture = "leg";
            return;
        }
        if (this.current_texture == "leg") {
            this.current_texture = "head";
            return;
        }
        if (this.current_texture == "head") {
            this.current_texture = "arm";
        }
    }
    public void pressLeftButton() {
        if (this.current_texture == "arm") {
            this.current_texture = "head";
            return;
        }
        if (this.current_texture == "leg") {
            this.current_texture = "arm";
            return;
        }
        if (this.current_texture == "head") {
            this.current_texture = "leg";
        }
    }
}

//    @Override protected void init() {
//        int i = (this.width - 168) / 2;
//        int j = (this.height - 175) / 2;
//        this.addButton(
//                new Button(i + 100, j + 60, 20, 20,
//                        new StringTextComponent(">"),
//                        (button) -> System.out.println("right button")));
//        this.addButton(
//                new Button (i + 5, j + 60, 20, 20,
//                        new StringTextComponent("<"),
//                        (button) -> System.out.println("left button")));
//        this.addButton(
//                new Button (this.height, j, 60, 20,
//                        new StringTextComponent("SELECT"),
//                        (button) -> System.out.println("middle button")));
//    }