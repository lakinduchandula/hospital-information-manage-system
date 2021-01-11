package sample.model;

import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class UploadProfileImg {
    private String username;
    private int usermode;
    private String NIC;

    public void setUsermode(int usermode) {
        this.usermode = usermode;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setNIC(String NIC){
        this.NIC = NIC;
    }

    public String getNIC(){
        return NIC;
    }

    public int getUsermode(){
        return usermode;
    }

    public String getUsername(){
        return username;
    }

    public String uploadProfilePicture(String oldProfileImgPath) throws IOException {
        FileChooser profileImage = new FileChooser();
        profileImage.setTitle("Select Profile Picture");
        FileChooser.ExtensionFilter imageExtensions = new FileChooser
                .ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png");
        profileImage.getExtensionFilters().add(imageExtensions);
        File UploadProfile = profileImage.showOpenDialog(null);

        String imgPath = "data/profile/" + RandomID.getUniqueId() + ".jpg";
        try{
            copyFile(UploadProfile, new File(imgPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgPath;
    }

    public void deleteOldProfileImg(String oldImgPath){
        File file = new File(oldImgPath);
        System.out.println(oldImgPath);
        if(file.exists()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
    }

    public String[] getProfileDetail(String username, int usermode){
        final String[] fileLocation = {"src/sample/data/UserReceptionist.txt", "src/sample/data/UserPatient.txt",
                "src/sample/data/UserMedicalOfficer.txt"
        };
        File file = new File(fileLocation[usermode]);
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(credentialValidation(userCredentials[0], username)){
                    return userCredentials;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean credentialValidation(String userCredential1, String userCredential2) {
        return userCredential1.equals(userCredential2);
    }

    private static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

}
