import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.HashSet;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes, Michael Kölling,= and Emmanuel duru
 * @version 2020.04.13
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }

    /**
     * List the names of files matching the given search string.
     * @param searchString The string to match.
     */
    public void listMatching(String searchString)
    {
        for(String filename : files) {
            if(filename.contains(searchString)) {
                // A match.
                System.out.println(filename);
            }
        }
    }

    /**
     * Find the index of the first file matching the given
     * search string.
     * @param searchString The string to match.
     * @return The index of the first occurrence, or -1 if
     *         no match is found.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        // Record that we will be searching until a match is found.
        boolean searching = true;

        while(searching && index < files.size()) {
            String filename = files.get(index);
            if(filename.contains(searchString)) {
                // A match. We can stop searching.
                searching = false;
            }
            else {
                // Move on.
                index++;
            }
        }
        if(searching) {
            // We didn't find it.
            return -1;
        }
        else {
            // Return where it was found.
            return index;
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
        /**
     * Find the indices of all file matching the given
     * search string.
     * @param searchString The string to match.
     * @return The array list of indices of all matching files, or only -1 in the arraylist if
     *         no match is found.
     */
    public ArrayList<Integer> findMatching (String searchString)
    {   
        int index =0;
        ArrayList<Integer>indices = new ArrayList<Integer>();
        while(index < files.size()){
            String fileName = files.get(index);
            if(fileName.contains(searchString))
                indices.add(index);
            index++;
        }
        
        if(indices.size() == 0)
            indices.add(-1);
        
        return indices;
    }
    
            /**
     * Find the set of file names of all file matching the given
     * search string.
     * @param searchString The string to match.
     * @return The array list of indices of all matching files, or only -1 in the arraylist if
     *         no match is found.
     */
    public HashSet<String> findAllMatching (String searchString)
    {   
        int index =0;
        HashSet<String> fileSet = new HashSet<String>();
        while(index < files.size()){
            String fileName = files.get(index);
            if(fileName.contains(searchString))
                fileSet.add(fileName);
            index++;
        }
        
        if(fileSet.size() == 0)
            fileSet.add("No matches found");
        
        return fileSet;
    }
}
