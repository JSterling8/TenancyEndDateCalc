package javagui.view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField tfEndDate;
	private JTextField tfMonths;
	private JTextField tfYears;
	private JTextField tfWeeks;
	private JRadioButton rbYears;
	private JRadioButton rbWeeks;
	private JRadioButton rbMonths;
	private JComboBox<String[]> cbDay;
	private JComboBox<String[]> cbMonth;
	private JComboBox<String[]> cbYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws URISyntaxException 
	 */
	public Main() throws URISyntaxException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/javagui/resources/icon.png")));
		setTitle("Tenancy End Date Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		// Icon platLogo = new ImageIcon(getClass().getResource("/resources/logo.png"));   	
		ImageIcon platLogo = createImageIcon("/javagui/resources/logo.png", "Platinum Logo");
		JLabel lPlatinumLogo = new JLabel(new ImageIcon(Main.class.getResource("/javagui/resources/logo.png")));

		JPanel pStartDate = new JPanel();
		pStartDate.setBorder(new TitledBorder(null, "Tenancy Start Date:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel pWMY = new JPanel();
		pWMY.setBorder(new TitledBorder(null, "Increment by:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel pCalculate = new JPanel();
		pCalculate.setBorder(new EmptyBorder(0, 0, 0, 0));

		final URI uri = new URI("http://www.FirstClassCreative.co.uk");
		
		JPanel pDesignedBy = new JPanel();
		pDesignedBy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO make link
			}
		});
		pDesignedBy.setBorder(new TitledBorder(null, "Designed By:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout fl_pDesignedBy = (FlowLayout) pDesignedBy.getLayout();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(pDesignedBy, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lPlatinumLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(pStartDate, GroupLayout.PREFERRED_SIZE, 156, Short.MAX_VALUE)
										.addComponent(pCalculate, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(pWMY, GroupLayout.PREFERRED_SIZE, 156, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lPlatinumLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(pStartDate, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pCalculate, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addComponent(pWMY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pDesignedBy, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		JLabel lblFirstClassCreative = new JLabel("First Class Creative");
		lblFirstClassCreative.setForeground(Color.BLUE);
		pDesignedBy.add(lblFirstClassCreative);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/javagui/resources/64x64fccLogo.png")));
		pDesignedBy.add(label);

		JButton bCalc = new JButton("Calculate End Date");
		pCalculate.add(bCalc);

		tfEndDate = new JTextField();
		pCalculate.add(tfEndDate);
		tfEndDate.setEditable(false);
		tfEndDate.setColumns(10);
		bCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (rbWeeks.isSelected()){
					calcEndDate(Calendar.WEEK_OF_YEAR, tfWeeks.getText());
				}
				else if (rbMonths.isSelected()){
					calcEndDate(Calendar.MONTH, tfMonths.getText());
				}
				else if (rbYears.isSelected()){
					calcEndDate(Calendar.YEAR, tfYears.getText());
				}
			}
		});

		rbWeeks = new JRadioButton("");
		rbWeeks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weeksClicked();
			}
		});
		rbWeeks.setSelected(true);

		JLabel lWeeks = new JLabel("Weeks:");
		lWeeks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weeksClicked();
			}
		});

		tfWeeks = new JTextField();
		tfWeeks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weeksClicked();
			}
		});

		rbYears = new JRadioButton("");
		rbYears.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearsClicked();
			}
		});

		tfYears = new JTextField();
		tfYears.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yearsClicked();
			}
		});
		tfYears.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbYears.isSelected()){
					calcEndDate(Calendar.YEAR, tfMonths.getText());
				}
			}
		});
		tfYears.setEditable(false);
		tfYears.setColumns(10);

		JLabel lblNumberOfYears = new JLabel("Years:");
		lblNumberOfYears.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yearsClicked();
			}
		});

		rbMonths = new JRadioButton("");
		rbMonths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monthsClicked();
			}
		});

		tfMonths = new JTextField();
		tfMonths.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthsClicked();
			}
		});
		tfMonths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbMonths.isSelected()){
					calcEndDate(Calendar.MONTH, tfMonths.getText());
				}
			}
		});
		tfMonths.setEditable(false);
		tfMonths.setColumns(10);

		JLabel lMonths = new JLabel("Months:");
		lMonths.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monthsClicked();
			}
		});
		GroupLayout gl_pWMY = new GroupLayout(pWMY);
		gl_pWMY.setHorizontalGroup(
				gl_pWMY.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pWMY.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pWMY.createParallelGroup(Alignment.TRAILING)
								.addComponent(rbWeeks)
								.addComponent(rbMonths)
								.addComponent(rbYears))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_pWMY.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pWMY.createSequentialGroup()
												.addComponent(lMonths, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(33))
												.addGroup(gl_pWMY.createSequentialGroup()
														.addComponent(lWeeks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(36))
														.addComponent(lblNumberOfYears)
														.addComponent(tfWeeks, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
														.addGroup(gl_pWMY.createSequentialGroup()
																.addComponent(tfMonths, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
																.addGap(1))
																.addComponent(tfYears, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
																.addGap(29))
				);
		gl_pWMY.setVerticalGroup(
				gl_pWMY.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pWMY.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pWMY.createParallelGroup(Alignment.LEADING)
								.addComponent(rbWeeks)
								.addGroup(gl_pWMY.createSequentialGroup()
										.addComponent(lWeeks)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfWeeks)))
										.addGap(8)
										.addGroup(gl_pWMY.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_pWMY.createSequentialGroup()
														.addComponent(lMonths)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(tfMonths))
														.addComponent(rbMonths))
														.addGap(11)
														.addGroup(gl_pWMY.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_pWMY.createSequentialGroup()
																		.addComponent(lblNumberOfYears)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(tfYears))
																		.addComponent(rbYears))
																		.addContainerGap())
				);
		pWMY.setLayout(gl_pWMY);
		tfWeeks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbWeeks.isSelected()){
					calcEndDate(Calendar.WEEK_OF_YEAR, tfWeeks.getText());
				}
			}
		});

		JLabel lYear = new JLabel("Year:");

		cbYear = new JComboBox();
		cbYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If it's a leap year and February has already been selected, make sure that 29 days are shown.
				if (((cbYear.getSelectedIndex() + 2013) % 4 == 0) && cbMonth.getSelectedIndex() == 1){
					cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
				}
				// If you're going from a leap year to a non-leap year and February is selected, set the date range back to 28.
				else if (cbMonth.getSelectedIndex() == 1){
					cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));

				}
			}
		});
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));

		JLabel lMonth = new JLabel("Month:");

		cbMonth = new JComboBox();
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));


		JLabel lDay = new JLabel("Day:");

		cbDay = new JComboBox();
		cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		GroupLayout gl_pStartDate = new GroupLayout(pStartDate);
		gl_pStartDate.setHorizontalGroup(
				gl_pStartDate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pStartDate.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pStartDate.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pStartDate.createSequentialGroup()
										.addComponent(lYear)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(cbYear, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_pStartDate.createSequentialGroup()
												.addGroup(gl_pStartDate.createParallelGroup(Alignment.LEADING)
														.addComponent(lMonth)
														.addComponent(lDay))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_pStartDate.createParallelGroup(Alignment.TRAILING)
																.addComponent(cbDay, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(cbMonth, 0, 81, Short.MAX_VALUE))))
																.addGap(3))
				);
		gl_pStartDate.setVerticalGroup(
				gl_pStartDate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pStartDate.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_pStartDate.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbYear, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
								.addComponent(lYear))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pStartDate.createParallelGroup(Alignment.BASELINE)
										.addComponent(lMonth)
										.addComponent(cbMonth))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_pStartDate.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lDay)
												.addComponent(cbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(12))
				);
		pStartDate.setLayout(gl_pStartDate);


		// Sets the number of days shown in cbDays based on the month selected.
		cbMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDays();
			}
		});
		contentPane.setLayout(gl_contentPane);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}


	public void calcEndDate(int fieldChanging, String input){
		try {
			// Gathers user input
			int day = (int) cbDay.getSelectedIndex()+1;
			int month = (int) cbMonth.getSelectedIndex();
			int year = (int) cbYear.getSelectedIndex() + 2013;
			Integer numToAdd = new Integer(input);


			// Makes a Calendar and sets it to the date entered
			Calendar cal = Calendar.getInstance();
			cal.clear();
			cal.set(year, month, day);

			// Adds the number of weeks specified
			cal.add(fieldChanging, numToAdd);
			cal.add(Calendar.DATE, -1);

			// Normalizes Calendar output
			int endDay = cal.get(Calendar.DAY_OF_MONTH);
			int endMonth = cal.get(Calendar.MONTH) + 1;
			int endYear = cal.get(Calendar.YEAR);

			// Puts output in the text box.
			tfEndDate.setText("" + endDay + "/" +
					endMonth + "/" +
					endYear);
		} catch (NumberFormatException e1) {
			if (fieldChanging == Calendar.WEEK_OF_YEAR){
				JOptionPane.showMessageDialog(Main.this,"You must enter a valid number of weeks.", "Enter weeks", JOptionPane.ERROR_MESSAGE);
			}
			else if (fieldChanging == Calendar.MONTH){
				JOptionPane.showMessageDialog(Main.this,"You must enter a valid number of months.", "Enter months", JOptionPane.ERROR_MESSAGE);

			}
			else if(fieldChanging == Calendar.YEAR){
				JOptionPane.showMessageDialog(Main.this,"You must enter a valid number of years.", "Enter years", JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	public void weeksClicked(){
		tfWeeks.setEditable(true);
		tfMonths.setEditable(false);
		tfMonths.setText("");
		tfYears.setEditable(false);
		tfYears.setText("");

		rbWeeks.setSelected(true);
		rbMonths.setSelected(false);
		rbYears.setSelected(false);
	}
	
	public void monthsClicked(){
		tfWeeks.setEditable(false);
		tfWeeks.setText("");
		tfMonths.setEditable(true);
		tfYears.setEditable(false);
		tfYears.setText("");

		rbWeeks.setSelected(false);
		rbMonths.setSelected(true);
		rbYears.setSelected(false);
	}
	
	public void yearsClicked(){
		tfWeeks.setEditable(false);
		tfWeeks.setText("");
		tfMonths.setEditable(false);
		tfYears.setText("");
		tfYears.setEditable(true);
		
		rbWeeks.setSelected(false);
		rbMonths.setSelected(false);
		rbYears.setSelected(true);
	}
	
	public void setDays(){
		if (cbMonth.getSelectedItem().equals("January")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("February")){
			Object o = cbDay.getSelectedItem();
			// If it's a leap year then February has 29 days, otherwise it has 28.
			if (((cbYear.getSelectedIndex()+2013) % 4) != 0){
				cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
			}
			else {
				cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
			}
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("March")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("April")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("May")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("June")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("July")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("August")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("September")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("October")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("November")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
			cbDay.setSelectedItem(o);
		}
		else if (cbMonth.getSelectedItem().equals("December")){
			Object o = cbDay.getSelectedItem();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setSelectedItem(o);
		}
	}
	
}
