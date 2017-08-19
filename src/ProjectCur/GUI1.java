package ProjectCur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class GUI1 {

	/**
	 * Create the application.
	 */
	public GUI1() {	
		initialize();
	}
	
	public Object[][] fillObject(Object[][] data) throws FileNotFoundException{
		
		CurrenciesRate Temp = new CurrenciesRate();
		for(int j=0; j<14;j++){
			    String[] sTemp = Temp.getFullLine(j,"asd.txt");
			for(int i=0; i<5 ;i++ ){
				data[j][i] = sTemp[i];
			}
		}
		return data;
	}
	public Object[] fillComboBox(Object[] data) throws FileNotFoundException{
		CurrenciesRate Temp = new CurrenciesRate();
		for(int j=0; j<14;j++){
			    String[] sTemp = Temp.getFullLine(j,"asd.txt");
			    data[j] = sTemp[0]+"("+sTemp[3]+")";
			    
			}
		return data;
		}
		
	

	JFrame frame;
	
	String[] columnNames = {"Name",
            "Unit",
            "CurrencyCode",
            "Country",
            "Rate"
            };
	
	Object[][] data;

	private JTable table;
	private JTextField textField;
	private JComboBox comboBoxF;
	private JComboBox comboBoxT;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI1 window = new GUI1();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Object[] namesData = new Object[14];
		Object[][] data = new Object[14][5] ;
		try{
		namesData=fillComboBox(namesData);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			fillObject(data);
			}catch (Exception e){
				e.printStackTrace();
			}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 572, 312);
		frame.getContentPane().add(tabbedPane_1);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Information", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Convertor", null, panel_1, null);
		panel_1.setLayout(null);

		JComboBox boxFrom = new JComboBox(namesData);
		boxFrom.setBounds(51, 31, 117, 25);
		panel_1.add(boxFrom);
		
		JComboBox boxTo = new JComboBox(namesData);
		boxTo.setBounds(51, 83, 117, 24);
		panel_1.add(boxTo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(212, 86, 187, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinner.setBounds(212, 31, 110, 25);
		panel_1.add(spinner);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int fr = boxFrom.getSelectedIndex();
				int to = boxTo.getSelectedIndex();
				String[] sFrom = new String[6];
				String[] sTo = new String[6];
				CurrenciesRate Temp = new CurrenciesRate();
				try {
					sFrom = Temp.getFullLine(fr,"asd.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sTo = Temp.getFullLine(to,"asd.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Double result;
				double getNum = (double) spinner.getValue();
				
				double fUNIT = Double.parseDouble(sFrom[1]);
				double fRATE = Double.parseDouble(sFrom[4]);
				double tUNIT = Double.parseDouble(sTo[1]);
				double tRATE = Double.parseDouble(sTo[4]);
				
				result= getNum*((fUNIT/fRATE) *( tRATE / tUNIT ));
				String FINALY = Double.toString(result);

				textField.setText(FINALY);
			}
		});
		btnConvert.setBounds(145, 232, 117, 25);
		panel_1.add(btnConvert);
		

		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 218, 421, 2);
		panel_1.add(separator);
		

		

		
	}
	public JTable getTable() {
		return table;
	}
}
