import javax.swing.*;
import java.util.List;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.util.Date;

//Interfete Grafice
//Adelina Bistriceanu
//Pentru a merge programul trebuie modificat la creearea fisierului ( in public void write ) cu numele Useru-ului de pe PC pe care este dorit sa se scrie in fisier
//La String path = "C:\\Users\\[Numele User-ului]\\eclipse-workspace\\Examen\\bin\\file.txt";

public class Examen implements ActionListener {
	JTextField NumeA_text,PrenumeA_text,NumeC_text,PrenumeC_text,Nr_tel_text,Serie_CI_text,Editura_text;
	JButton Save;
	JLabel lbl_Edit,lbl_info,lbl_NumeA, lbl_PrenumeA,lbl_NumeC,lbl_PrenumeC,lbl_Tel,lbl_serie,lbl_DataR;
	SpinnerDateModel spinMod=new SpinnerDateModel();
    JSpinner spin=new JSpinner(spinMod);
	Examen(){
		
		JFrame f=new JFrame();
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.getContentPane().setBackground(Color.lightGray);
		spin.setBounds(120, 190, 90, 24);
		NumeA_text=new JTextField();
		NumeA_text.setBounds(100, 100, 100, 24);//
		PrenumeA_text=new JTextField();
		PrenumeA_text.setBounds(310, 100, 100, 24);//
		NumeC_text=new JTextField();
		NumeC_text.setBounds(100, 130, 100, 24);//
		PrenumeC_text=new JTextField();
		PrenumeC_text.setBounds(310, 130, 100, 24);//
		Nr_tel_text=new JTextField();
		Nr_tel_text.setBounds(310, 160, 100, 24);//
		Serie_CI_text=new JTextField();
		Serie_CI_text.setBounds(100, 160, 100, 24);//
		lbl_NumeA=new JLabel();
		lbl_NumeA.setText("Nume Autor:");  
        lbl_NumeA.setBounds(15,98, 100,30);//
        lbl_PrenumeA=new JLabel();  
        lbl_PrenumeA.setText("Prenume Autor:");  
        lbl_PrenumeA.setBounds(210,96, 100,30);//
        lbl_NumeC=new JLabel();  
        lbl_NumeC.setText("Nume Client:");  
        lbl_NumeC.setBounds(15,128, 100,30);//
        lbl_PrenumeC=new JLabel();  
        lbl_PrenumeC.setText("Prenume Client:");  
        lbl_PrenumeC.setBounds(210,128, 100,30);
        lbl_Tel=new JLabel();  
        lbl_Tel.setText("Numar Telefon:");  
        lbl_Tel.setBounds(210,158, 100,30);
        lbl_serie=new JLabel();  
        lbl_serie.setText("Serie CI:");  
        lbl_serie.setBounds(15,158, 100,30);
        lbl_DataR=new JLabel();  
        lbl_DataR.setText("Data Restituire:");  
        lbl_DataR.setBounds(15,186, 100,30);
        lbl_info=new JLabel();
        lbl_info.setText("Completati Datele");
        lbl_info.setBounds(10, 10, 150, 50);
        Editura_text=new JTextField();
        Editura_text.setBounds(470, 100, 100, 24);
        lbl_Edit=new JLabel();
        lbl_Edit.setText("Editura:");
        lbl_Edit.setBounds(420, 98, 100, 30);
        
        
        
        JButton Save=new JButton("Salveaza");  
        Save.setBounds(230,250,100,50);   
        Save.addActionListener(new ActionListener()
        		{
        	
        	public void actionPerformed(ActionEvent e)
        	{ 	
        	String NumeA=NumeA_text.getText();
        	String PrenumeA=PrenumeA_text.getText();
    		String Editura=Editura_text.getText();
    		String ClientN=NumeC_text.getText();
    		String ClientP=PrenumeC_text.getText();  
    		String tel=Nr_tel_text.getText();
    		String Serie=Serie_CI_text.getText();
    		String data=spin.getValue().toString();
    		List<String> lst=List.of(NumeA,PrenumeA,Editura,ClientN,ClientP,tel,Serie,data);
        	Date dt=(Date) spin.getValue(); 
        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	Date daten = new Date();
        	System.out.println(dateFormat.format(daten)); 
        	int nrz=0;
        	nrz=1+(int)( (dt.getTime() - daten.getTime())/ (1000 * 60 * 60 * 24));
        	int nrSapt=nrz/7;
        	int nrzile=nrz%7;
        	String r = "Au ramas "+Integer.toString(nrSapt)+" saptamani si "+Integer.toString(nrzile)+" zi(le)\n pana la returnare.";
        	infoBox(r,"Atentie!");
         	write();
         	clearText();
        	}
        	
        	
        		});
        f.add(Nr_tel_text);f.add(NumeA_text);f.add(NumeC_text);f.add(PrenumeA_text);f.add(PrenumeC_text);f.add(Serie_CI_text);f.add(Editura_text);
        f.add(lbl_DataR);f.add(lbl_NumeA);f.add(lbl_NumeC);f.add(lbl_PrenumeA);f.add(lbl_PrenumeC);f.add(lbl_Tel);f.add(lbl_info);f.add(lbl_serie);f.add(lbl_Edit);
        f.add(spin);
        f.add(Save);
		f.setLayout(null);
		f.setVisible(true);
		spin.setEditor(new JSpinner.DateEditor(spin,"dd.MM.yyyy"));
	
        		
        		}
	
	
	
	public void clearText()
	{
		NumeA_text.setText("");
    	PrenumeA_text.setText("");
		Editura_text.setText("");
		NumeC_text.setText("");
		PrenumeC_text.setText("");
		Nr_tel_text.setText("");
		Serie_CI_text.setText("");
	}
	public void write()
	{
		    try
		    {
		        String path = "C:\\Users\\Piloucu\\eclipse-workspace\\Examen\\bin\\file.txt";

		        File file = new File(path);

		        FileWriter fileWriter = new FileWriter(file,true);

		        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

		        fileWriter.append("Nume Autor: "+NumeA_text.getText().toString()+" "+
		        		"  Prenume Autor: "+PrenumeA_text.getText().toString()+" "+
		        		"  Editura: "+Editura_text.getText().toString()+" "+
		        		"  Nume Client: "+NumeC_text.getText().toString()+" "+
						"  Prenume Client: "+PrenumeC_text.getText().toString()+" "+
						"  Numar telefon: "+Nr_tel_text.getText().toString()+" "+
						"  Serie_CI: "+Serie_CI_text.getText().toString()+" "+
						"  Data: "+spin.getValue().toString()+"\n");

		        bufferFileWriter.close();

		        System.out.println("Data inserted to file");

		    }catch(Exception ex)
		    {
		        System.out.println(ex);
		    }
	}
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage , titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
public static void main(String[] args)
{	
	new Examen();
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	