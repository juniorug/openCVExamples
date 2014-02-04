package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import com.junior.opencv.Mat2Image;

public class TrackBar extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel graphicPanel;
	private JPanel rightPanel;
	private JScrollBar sbBrightness;
    private JScrollBar sbContrast;
    private JLabel lbBrightness;
    private JLabel lbContrast;
    private double brightness ;
    private double contrast;
    private static int ZERO = 0;
    private static int MAX = 255;
    private static int MIN = -255;
    private static int RTYPE = -1;
    private static int INITIAL_CONTRAST = 100;
    private static int MAX_CONTRAST = 200;
    private static String IMAGEPATH = "img/Jellyfish.jpg"; 
    private static Mat m;
	
	public TrackBar(int height, int width)
	{
		setTitle("TrackBar") ;
        setSize(width + 300,height + 100);
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout());
        initComponents();
        setVisible(true);
        repaint();
	}
	
	private void initComponents() 
    {
		brightness = ZERO;
		contrast = INITIAL_CONTRAST;
		//labels
		lbBrightness = new JLabel("Brightness: "+ Double.toString(brightness));
		lbContrast = new JLabel("Contrast: "+ Double.toString(contrast/INITIAL_CONTRAST));
		
		//scrollBars
        sbBrightness = new JScrollBar(JScrollBar.HORIZONTAL);
        sbContrast = new JScrollBar(JScrollBar.HORIZONTAL);
        sbBrightness.setMinimum(MIN);
        sbBrightness.setMaximum(MAX);
        sbBrightness.setValue(ZERO);
        sbActionListener(sbBrightness);
        sbContrast.setMinimum(ZERO);
        sbContrast.setMaximum(MAX_CONTRAST);
        sbContrast.setValue(INITIAL_CONTRAST);
        sbActionListener(sbContrast);
        
		graphicPanel = new JPanel();
    	rightPanel = new JPanel();
    	
    	configurePanels();
    	
    	
    }
	
	private void configurePanels() {
		
		rightPanel.setLayout(new GridLayout(2,2));
		Border border = BorderFactory.createEmptyBorder(300, 20, 300, 20);
		rightPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        rightPanel.setBorder(border);

    	rightPanel.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
    	rightPanel.add(sbBrightness);
    	rightPanel.add(lbBrightness);
    	rightPanel.add(sbContrast);
    	rightPanel.add(lbContrast);
    	add(rightPanel,BorderLayout.WEST);
    	
    	String imgStr = IMAGEPATH;
    	//Mat m = Highgui.imread(imgStr,Highgui.CV_LOAD_IMAGE_COLOR);
    	//ImageIcon image = new ImageIcon(imgStr);
    	Mat2Image mat2Img = new Mat2Image(m);
    	BufferedImage image = mat2Img.getImage(m);
    	JLabel label1 = new JLabel(new ImageIcon(image), JLabel.CENTER); 
	
    	this.getContentPane().add(label1); 
    	
    	//add(graphicPanel,BorderLayout.CENTER);
	}
	
	/*** sbActionListener(JScrollBar jsb)***/
    private void sbActionListener(JScrollBar jsb)
    {
    	jsb.addAdjustmentListener(new AdjustmentListener()
    	{
    		@Override
    		public void adjustmentValueChanged(AdjustmentEvent ae) 
    		{
    			if (ae.getSource() == sbBrightness)
    			{
    				brightness = ae.getValue();
    				//gc.setRed(r);
    				lbBrightness.setText("Brightness: "+ Double.toString(brightness));
    			}else if(ae.getSource() == sbContrast)
    			{
    				contrast = ae.getValue()/INITIAL_CONTRAST;
    				//gc.setGreen(g);
    				lbContrast.setText("Contrast: "+ Double.toString(contrast/INITIAL_CONTRAST));
    			}
				//gc.repaint();
    			m.convertTo(m, RTYPE, contrast, brightness);
    		}
    	 });
    }    
	
	 /*** @param args the command line arguments***/
    public static void main(String args[]) 
    {	
    	System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
    	m = Highgui.imread(IMAGEPATH,Highgui.CV_LOAD_IMAGE_COLOR);
    	TrackBar tb = new TrackBar(m.height(), m.width());
    
    }   
	

}
