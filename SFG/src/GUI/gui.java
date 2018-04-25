package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import Componenets.Branch;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGraph;
	private int nodes, branches;
	private ArrayList<Branch> operations = new ArrayList<>();
	private static final String styleSheet = " graph{" + " 	text-style: bold;" + "text-size: 40px;" + "}"
			+ "		node {" + "	size: 30px;" + "	fill-color: black;" + "	text-background-mode: rounded-box;"
			+ "	text-background-color: rgb(0,0,0);" + "   text-color: white;" + "   text-size: 22px;"
			+ "   text-padding: 5px;" + "	text-alignment: under;" + "}"+ " edge{" + "  text-size: 20px;"
			+ "text-style: bold;" + "	text-alignment: under;" + "    shape: freeplane;" + "text-color: red;" + "}";
	private static final String styleFedge = " edge{" + "  text-size: 20px;"
			+ "text-style: bold;" + "	text-alignment: above;" + "    shape: freeplane;" + "text-color: red;" + "}";
	private static final String styleSedge = " edge{" + "  text-size: 20px;"
			+ "text-style: bold;" + "	text-alignment: under;" + "    shape: freeplane;" + "text-color: red;" + "}";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 1086, 767);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1068, 88);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number of Nodes :");
		lblEnterNumberOf.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterNumberOf.setBounds(12, 13, 237, 26);
		panel.add(lblEnterNumberOf);
		
		textField = new JTextField();
		textField.setBounds(12, 42, 138, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterNumberOf_1 = new JLabel("Enter Number of Branches :");
		lblEnterNumberOf_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterNumberOf_1.setBounds(337, 13, 258, 26);
		panel.add(lblEnterNumberOf_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(337, 42, 138, 33);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("SOLVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nodes = Integer.parseInt(textField.getText());
				branches = Integer.parseInt(textField_1.getText());
				for (int i=0;i<branches;i++){
					String op = JOptionPane.showInputDialog("Enter Branch like From, To , Gain");
					op=op.replaceAll(" ", "");
					String [] parameters = op.split(",");
					operations.add(new Branch(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]),Integer.parseInt(parameters[2])));
					//TODO CLASS ZEYAD 
					
				}
				
				//TODO PARSE ARRAYLIST AND PASS IT 
				btnGraph.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(661, 13, 129, 50);
		panel.add(btnNewButton);
		
		btnGraph = new JButton("GRAPH");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        Graph graph = new SingleGraph("Graph");
		        for(int i=0;i<nodes;i++){
		        	graph.addNode(String.valueOf(i+1));
					Node n = graph.getNode(String.valueOf(i+1));
					n.addAttribute("ui.label", "Node " + (i+1));
		        }
		        for(int i=0;i<branches;i++){
		        	Branch temp = operations.get(i);
		        	graph.addEdge(String.valueOf(temp.getGain()),String.valueOf(temp.getFrom()),String.valueOf(temp.getTo()),true);
		        	Edge e = graph.getEdge(String.valueOf(temp.getGain()));
					e.addAttribute("ui.label", String.valueOf(temp.getGain()));
				//	e.addAttribute("ui.stylesheet", styleSheet);
		        }
			//graph.addAttribute("ui.stylesheet", styleSheet);
				System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
				graph.addAttribute("ui.quality");
		        graph.display();

			}
		});
		btnGraph.setForeground(Color.WHITE);
		btnGraph.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnGraph.setBackground(Color.BLACK);
		btnGraph.setBounds(866, 13, 129, 50);
		btnGraph.setVisible(false);
		panel.add(btnGraph);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 101, 1046, 606);
		frame.getContentPane().add(textArea);
		JScrollPane c = new JScrollPane(textArea);
		c.setBounds(10, 101, 1046, 606);
		frame.getContentPane().add(c);
		
	}
}
