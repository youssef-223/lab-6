


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author noha3
 */
public class JavaLab6 {

    public static void main(String[] args) {
        try{
            String fileName = args[0];
            if(!fileName.endsWith(".arxml")){
                throw new NotVaildAutosarFileException("invalid file extension");
            }
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            if(inputStream.read()==-1){
                throw new EmptyException("EmptyAutosarFileEexception");
            }
            int x;
            StringBuilder stringBuilder = new StringBuilder();
            while((x=inputStream.read()) != -1){
                stringBuilder.append((char)x);
            }
            String content = stringBuilder.toString();
            
            Scanner scanner = new Scanner(content);
            ArrayList<Container> containers = new ArrayList<>();
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                
                if(line.contains("<CONTAINER")){
                    String id = line.substring(line.indexOf("UUID="),line.indexOf(">"));
                    
                    String shortName = scanner.nextLine();
                    String shortN = shortName.substring(shortName.indexOf(">")+1,shortName.indexOf("</"));
                    
                    String longName = scanner.nextLine();
                    String longN = longName.substring(longName.indexOf(">")+1, longName.indexOf("</"));
                    
                    Container container = new Container();
                    container.setID(id);
                    container.setLongName(longN);
                    container.setShortName(shortN);
                    
                    containers.add(container);
                    
                }
            }
            
            Collections.sort(containers);
            String outputFile = fileName.substring(0,fileName.indexOf("."))+ "_mod.arxml";
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n".getBytes());
            
            for(int i =0; i<containers.size();i++){
                outputStream.write(containers.get(i).toString().getBytes());
            }
            outputStream.write("</AUTOSAR>\n".getBytes());
        }
        catch(FileNotFoundException e){
            e = new FileNotFoundException("File Not Found!");
            
        }
        catch(IOException e){
            e = new IOException("IO Exception");
        }
        catch(NotVaildAutosarFileException e){
            e = new NotVaildAutosarFileException("Not Valid");
            
        }
       
    }
}
