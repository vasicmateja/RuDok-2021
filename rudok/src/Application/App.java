package Application;

import DataStorage.DataStorage;
import model.*;
import view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args){
        DataStorage.getInstance();
        MainFrame mf = MainFrame.getInstance();
        mf.setVisible(true);

//        Object[] options = {"Yes",
//                "No"};
//        int n = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Zelite li novi workspace ", "Open workspace", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
//        if(n==0){
//            Project project;
//            WorkSpace workspace = DataStorage.getInstance().workSpace;
//            workspace.lista.clear();
//
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setFileFilter(new FileFilter() {
//
//                public String getDescription() {
//                    return "RuDok Workspace (*.txt)";
//                }
//
//                public boolean accept(File f) {
//                    if (f.isDirectory()) {
//                        return true;
//                    } else {
//                        String filename = f.getName().toLowerCase();
//                        return filename.endsWith(".txt");
//                    }
//                }
//            });
//            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+ "/Desktop"));
//            int result = fileChooser.showOpenDialog(null);
//            if(result==JFileChooser.APPROVE_OPTION){
//                try
//                {
//                    File file=fileChooser.getSelectedFile();
//                    FileReader fr=new FileReader(file);
//                    BufferedReader br=new BufferedReader(fr);
//                    String line;
//                    while((line=br.readLine())!=null)
//                    {
//
//                        try{
//                            File f = new File(line);
//                            FileInputStream fileIn = new FileInputStream(line);
//                            ObjectInputStream in = new ObjectInputStream(fileIn);
//                            project = (Project) in.readObject();
//                            project.setFile(f);
//                            project.setChanged(false);
//                            in.close();
//                            fileIn.close();
//                            for(RuNodeComp ruNodeComp :project.lista){
//                                if(ruNodeComp instanceof Presentation presentation){
//                                    presentation.setParent(presentation);
//                                }
//                            }
//                            project.setParent(DataStorage.getInstance().workSpace);
//                            DataStorage.getInstance().workSpace.addChild(project);
//
//                        }
//                        catch (Exception e){
//                            System.out.println("ERROR");
//                        }
//                    }
//                    SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
//                    fr.close();
//                }
//                catch(IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//
//        }
    }
}
