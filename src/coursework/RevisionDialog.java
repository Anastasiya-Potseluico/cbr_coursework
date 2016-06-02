/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import jcolibri.cbrcore.CBRCase;
import jcolibri.util.FileIO;
/**
 *
 * @author Анастасия
 */

class RevisionDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	JLabel image;
	JComboBox carcassesType;
	JComboBox mark;
	JComboBox TiresType;
	JComboBox track;
	JComboBox weather;
	JLabel caseId;
        JTextField Result;
	
	ArrayList<CBRCase> cases;
	int currentCase;
	
	public RevisionDialog(JFrame main)
	{
		super(main, true);
		configureFrame();
	}
	
	private void configureFrame()
	{
		try
		{
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1)
		{
		}
		
		this.setTitle("Revise Cases");

		
		image = new JLabel();
		image.setIcon(new ImageIcon(FileIO.findFile("jcolibri/examples/TravelRecommender/gui/step5.png")));
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(image, BorderLayout.WEST);
		
		
		/**********************************************************/
		JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(8,2));
		panel.setLayout(new SpringLayout());
		
		JLabel label;

		panel.add(label = new JLabel("Description"));
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		panel.add(label = new JLabel());

		
		panel.add(new JLabel("carcassesType"));
		String[] carcassesTypes = {"diagonal", "radial"};
		panel.add(carcassesType = new JComboBox(carcassesTypes));
                
                panel.add(new JLabel("mark"));
		String[] marks = {"vaz", "kama","pirrely"};
		panel.add(mark = new JComboBox(marks));
                
                panel.add(new JLabel("TiresType"));
		String[] TiresTypes = {"pseslick", "slick","rainy"};
		panel.add(TiresType = new JComboBox(TiresTypes));
                
                panel.add(new JLabel("track"));
		String[] tracks = {"avtodrom", "city"};
		panel.add(track = new JComboBox(tracks));
                
                panel.add(new JLabel("weather"));
		String[] weathers = {"wet", "dry"};
		panel.add(weather = new JComboBox(weathers));
		
//		panel.add(new JLabel("Number of persons"));
//		numberOfPersons = new SpinnerNumberModel(2,1,12,1); 
//		panel.add(new JSpinner(numberOfPersons));
//		
//		panel.add(new JLabel("Region"));
//		//String[] regions = {
//		//		"AdriaticSea","Algarve","Allgaeu","Alps","Atlantic","Attica","Balaton","BalticSea","Bavaria","Belgium","BlackForest","Bornholm","Brittany","Bulgaria","Cairo","Carinthia","Chalkidiki","Corfu","Corsica","CostaBlanca","CostaBrava","CotedAzur","Crete","Czechia","Denmark","Egypt","England","ErzGebirge","Fano","France","Fuerteventura","GiantMountains","GranCanaria","Harz","Holland","Ibiza","Ireland","LakeGarda","Lolland","Madeira","Mallorca","Malta","Normandy","NorthSea","Poland","Rhodes","Riviera","SalzbergerLand","Scotland","Slowakei","Styria","Sweden","Teneriffe","Thuringia","Tunisia","TurkishAegeanSea","TurkishRiviera","Tyrol","Wales"};
//		panel.add(region = new RegionSelector(this));
//		
//		panel.add(new JLabel("Transportation"));
//		String[] transportations = {"Plane","Car","Coach","Train"};
//		panel.add(transportation = new JComboBox(transportations));
//		
//		panel.add(new JLabel("Duration"));
//		duration = new SpinnerNumberModel(7,2,31,1); 
//		panel.add(new JSpinner(duration));
//		
//		panel.add(new JLabel("Season"));
//		String[] seasons = {"January","February","March","April","May","June","July","August","September","October","November","December"};
//		panel.add(season = new JComboBox(seasons));
//		
//		panel.add(new JLabel("Accommodation"));
//		String[] accommodations = {"FiveStars","FourStars","HolidayFlat","ThreeStars","TwoStars","OneStar"};
//		panel.add(accommodation = new JComboBox(accommodations));
		
		panel.add(label = new JLabel("Solution"));
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		panel.add(label = new JLabel());
                panel.add(new JLabel("Result"));
                panel.add(Result = new JTextField());

		
//		panel.add(new JLabel("Price"));
//		price = new SpinnerNumberModel(); 
//		panel.add(new JSpinner(price));
//		
//		panel.add(new JLabel("Hotel"));
//		panel.add(hotel = new JTextField());
		
//		Lay out the panel.
		Utils.makeCompactGrid(panel,
		                11, 2, //rows, cols
		                6, 6,        //initX, initY
		                30, 10);       //xPad, yPad
		
		JPanel casesPanel = new JPanel();
		casesPanel.setLayout(new BorderLayout());
		casesPanel.add(panel, BorderLayout.CENTER);
		
		JPanel casesIterPanel = new JPanel();
		casesIterPanel.setLayout(new FlowLayout());
		JButton prev = new JButton("<<");
		casesIterPanel.add(prev);
		casesIterPanel.add(caseId = new JLabel("Case id"));
		JButton follow = new JButton(">>");
		casesIterPanel.add(follow);
		
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				saveCase();
				currentCase = (currentCase+cases.size()-1) % cases.size();
				showCase();
			}
		});
		
		follow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				saveCase();
				currentCase = (currentCase+1) % cases.size();
				showCase();
			}
		});
		
		casesPanel.add(casesIterPanel, BorderLayout.NORTH);
		
		
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new BorderLayout());
		panelAux.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panelAux.add(casesPanel,BorderLayout.NORTH);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		
		JButton ok = new JButton("Set Revisions >>");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				saveCase();
				next();
			}
		});
		buttons.add(ok,BorderLayout.CENTER);
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					InterfaceWidgetRecommender.getInstance().postCycle();
				} catch (Exception ex) {
					org.apache.commons.logging.LogFactory.getLog(InterfaceWidgetRecommender.class).error(ex);
				}
				System.exit(-1);
			}
		});
		buttons.add(exit,BorderLayout.WEST);
		
		panelAux.add(buttons, BorderLayout.SOUTH);
		this.getContentPane().add(panelAux, BorderLayout.CENTER);
		
		/**********************************************************/
		
		
		this.pack();
		this.setSize(600, this.getHeight());
		this.setResizable(false);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - this.getWidth()) / 2,
			(screenSize.height - this.getHeight()) / 2, 
			getWidth(),
			getHeight());
	}
	
	void next()
	{
		this.setVisible(false);
	}
	
	
	public void showCases(Collection<CBRCase> cases)
	{
		this.cases = new ArrayList<CBRCase>(cases);
		currentCase = 0;
		showCase();
	}
	
	void showCase()
	{
		CBRCase _case = cases.get(currentCase);
		this.caseId.setText(_case.getID().toString()+" ("+(currentCase+1)+"/"+cases.size()+")");
		
		InterfaceDescription desc = (InterfaceDescription) _case.getDescription();
                
		this.carcassesType.setSelectedItem(desc.getCarcassesType().toString());
		this.mark.setSelectedItem(desc.getMark());
		this.TiresType.setSelectedItem(desc.getTiresType());
		this.track.setSelectedItem(desc.getTrack());
		this.weather.setSelectedItem(desc.getWeather());
		
		InterfaceSolution sol = (InterfaceSolution) _case.getSolution();
		this.Result.setText(sol.getResult().toString());
	}
	
	void saveCase()
	{
		CBRCase _case = cases.get(currentCase);
		this.caseId.setText(_case.getID().toString()+" ("+(currentCase+1)+"/"+cases.size()+")");
		
		InterfaceDescription desc = (InterfaceDescription) _case.getDescription();
		
		desc.setMark((String)this.mark.getSelectedItem());
                desc.setCarcassesType((String)this.carcassesType.getSelectedItem());
                desc.setTiresType((String)this.TiresType.getSelectedItem());
                desc.setTrack((String)this.track.getSelectedItem());
                desc.setWeather((String)this.weather.getSelectedItem());
		
		InterfaceSolution sol = (InterfaceSolution) _case.getSolution();
		sol.setResult(this.Result.getText());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RevisionDialog qf = new RevisionDialog(null);
		qf.setVisible(true);
		System.out.println("Bye");
	}

	

}
