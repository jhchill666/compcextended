package com.tiltdigital.compcx.types;

import java.io.File;

import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.types.Commandline;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.util.FileUtils;

import flex.ant.config.OptionSource;
import flex.ant.config.OptionSpec;

public class FlexAssetFileSet extends FileSet implements OptionSource
{
    protected final OptionSpec spec;
    protected final boolean includeDirs;

    protected boolean append;

    public FlexAssetFileSet()
    {
        this(false);
    }

    public FlexAssetFileSet(OptionSpec spec)
    {
        this(spec, false);
    }

    public FlexAssetFileSet(boolean dirs)
    {
        spec = null;
        includeDirs = dirs;
        append = false;
    }

    public FlexAssetFileSet(OptionSpec spec, boolean dirs)
    {
        this.spec = spec; 
        includeDirs = dirs;
        append = false;
    }

    public void setAppend(boolean value)
    {
        append = value;
    }

    /**
     * Adds each asset to the cmdl as an 'include-file' argument
     */
    public void addToCommandline(Commandline cmdl)
    {
    	FileUtils utils = FileUtils.getFileUtils();
        DirectoryScanner scanner = getDirectoryScanner(getProject());
        String[] files = scanner.getIncludedFiles();
        
        for (int i = 0; i < files.length; i++)
        {
        	File file = utils.resolveFile(scanner.getBasedir(), files[i]);
        	String argument = "-include-file="+files[i]+","+file.getAbsolutePath();
        	
            cmdl.createArgument().setValue(argument);
            System.out.println("Compc :: "+argument);
        }
    }
}