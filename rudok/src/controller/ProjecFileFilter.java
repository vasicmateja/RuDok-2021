package controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjecFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".rpf"));
    }

    @Override
    public String getDescription() {
        return "RuDok Project Files (*.rpf)";
    }
}
