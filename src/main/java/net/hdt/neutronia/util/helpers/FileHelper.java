package net.hdt.neutronia.util.helpers;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class FileHelper
{
    public static void copyDirectoryToDirectory(File sourceDirectory, File destinationDirectory)
    {
        if(sourceDirectory != null && destinationDirectory != null)
        {
            String sourcePath = sourceDirectory.getPath();
            String destinationPath = destinationDirectory.getPath();
            URL resource = null;

            try
            {
                resource = sourceDirectory.toURI().toURL();
            }
            catch(MalformedURLException e)
            {
                e.printStackTrace();
            }

            if(resource != null)
            {
                if(resource.getProtocol().equals("jar"))
                {
                    try
                    {
                        JarFile jar = new JarFile(sourceDirectory);
                        Enumeration<? extends JarEntry> jarEntries = jar.entries();

                        while(jarEntries.hasMoreElements())
                        {
                            File jarFile = new File(jarEntries.nextElement().toString());
                            File destinationFile = new File(destinationPath, jarFile.getName());

                            if(!destinationFile.exists())
                            {
                                if(getFileExtension(destinationFile).equals(""))
                                {
                                    destinationFile.mkdirs();
                                }
                                else
                                {
                                    copyFile(jarFile, destinationFile);
                                }
                            }
                        }
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(resource.getProtocol().equals("file"))
                {
                    for(File file : FileUtils.listFilesAndDirs(sourceDirectory, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE))
                    {
                        File destinationFile = new File(destinationPath, file.getPath().substring(sourcePath.length()));

                        if(!destinationFile.exists())
                        {
                            if(getFileExtension(destinationFile).equals(""))
                            {
                                destinationFile.mkdirs();
                            }
                            else
                            {
                                copyFile(file, destinationFile);
                            }
                        }
                    }
                }
            }
        }
    }

    public static String getFileExtension(File file)
    {
        int dotIndex = file.getName().lastIndexOf('.');
        return dotIndex == -1 ? "" : file.getName().substring(dotIndex + 1);
    }

    private static void copyFile(File sourceFile, File destinationFile)
    {
        try
        {
            InputStream inputStream = new FileInputStream(sourceFile);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destinationFile));
            IOUtils.copy(inputStream, outputStream);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}