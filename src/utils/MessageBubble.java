package utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class MessageBubble extends JPanel {

	private static final long serialVersionUID = -7770093941183995361L;
	private int strokeThickness;
    private int padding;
    private int arrowSize;
    private int radius;
    
    public MessageBubble() {
    	this.strokeThickness = 5;
    	this.padding =  strokeThickness / 2;
    	this.arrowSize = 6;
    	this.radius = 10;
    }
    
    public void paintRightBubbleComponent(final Graphics graphics) {
        final Graphics2D graphics2D = (Graphics2D) graphics;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(qualityHints);
        graphics2D.setColor(new Color(20, 130, 230));
        graphics2D.setStroke(new BasicStroke(strokeThickness));
        int width = getWidth() - arrowSize - (strokeThickness * 2);
        int height = getHeight() - strokeThickness;
        graphics2D.fillRect(padding, padding, width, height);
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(padding, padding, width, height, radius, radius);
        Polygon arrow = new Polygon();
        arrow.addPoint(width, 6);
        arrow.addPoint(width + arrowSize, 10);
        arrow.addPoint(width, 12);
        Area area = new Area(rect);
        area.add(new Area(arrow));
        graphics2D.draw(area);
        graphics2D.dispose();
    }
    
    
    public void paintLeftBubbleComponent(final Graphics g) {
        final Graphics2D graphics2D = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(qualityHints);
        graphics2D.setPaint(new Color(80, 150, 180));
        int width = getWidth();
        int height = getHeight();
        GeneralPath path = new GeneralPath();
        path.moveTo(5, 10);
        path.curveTo(5, 10, 7, 5, 0, 0);
        path.curveTo(0, 0, 12, 0, 12, 5);
        path.curveTo(12, 5, 12, 0, 20, 0);
        path.lineTo(width - 10, 0);
        path.curveTo(width - 10, 0, width, 0, width, 10);
        path.lineTo(width, height - 10);
        path.curveTo(width, height - 10, width, height, width - 10, height);
        path.lineTo(15, height);
        path.curveTo(15, height, 5, height, 5, height - 10);
        path.lineTo(5, 15);
        path.closePath();
        graphics2D.fill(path);
    }
    

}
