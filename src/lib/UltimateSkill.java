package lib;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.TextAlignment;
import model.GameText;
import model.Hero;

public abstract class UltimateSkill extends Skill {
	
	protected int maxUltimatePoint;
	protected int ultimatePoint;
	protected boolean isUse;
	protected int ultimateDuration;
	protected GameText readyText;
	
	public UltimateSkill(int maxUltimatePoint, int x, int y, int z, Hero hero, KeyCode keyCode, int ultimateDuration) {
		super(0, x, y, z, hero, keyCode);
		// TODO Auto-generated constructor stub
		this.maxUltimatePoint = maxUltimatePoint;
		this.ultimatePoint = 0;
		this.isUse = false;
		this.ultimateDuration = ultimateDuration;
		this.readyText = new GameText(keyCode != null ? keyCode.toString() : "", x, y, z, 0, 54, Color.WHITE, Color.WHITE);
	}
	
	public void increaseUltimatePoint() {
		if(!isUse) {
			this.ultimatePoint++;
			if(this.ultimatePoint > this.maxUltimatePoint) this.ultimatePoint = this.maxUltimatePoint;
		}
	}
	
	@Override
	public void render(GraphicsContext gc) {
		
		gc.setLineWidth(8);
		
		if(ultimatePoint < maxUltimatePoint) gc.setFill(Color.color(0, 0, 0, 0.5));
		else gc.setFill(Color.color(1, 1, 1, 0.5));
		gc.fillOval(x - 35, y - 35, 70, 70);
		
		gc.setStroke(Color.color(1, 1, 1, 0.5));
		gc.strokeOval(x - 35, y - 35, 70, 70);
		
		gc.setStroke(Color.WHITE);
		gc.strokeArc(x - 35, y - 35, 70, 70, 90 - ultimatePoint * 360 / maxUltimatePoint, ultimatePoint * 360 / maxUltimatePoint, ArcType.OPEN);
		
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.setFill(Color.WHITE);
		
		if(ultimatePoint < maxUltimatePoint) {
			gc.setFont(IRenderableHolder.mainFont[28]);
			gc.fillText((ultimatePoint * 100 / maxUltimatePoint) + "%", x, y);
		}
		else {
			readyText.render(gc);
		}
	}
	
	@Override
	public void renderAnimation(GraphicsContext gc) {
		
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return isUse;
	}

}
