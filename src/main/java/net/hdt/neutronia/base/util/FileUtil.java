package net.hdt.neutronia.base.util;

import net.hdt.neutronia.base.NeutroniaMain;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileUtil {

    public static void extractFromJar(String sourcePath, String destinationPath) {
        URL sourceURL = NeutroniaMain.class.getResource(sourcePath);
        String fromPath = sourcePath.substring(1);

        if (sourceURL != null && sourceURL.getProtocol().equals("jar")) {
            try {
                JarURLConnection jarURLConnection = (JarURLConnection) sourceURL.openConnection();
                ZipFile zipFile = jarURLConnection.getJarFile();
                Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();

                while (zipEntries.hasMoreElements()) {
                    ZipEntry zipEntry = zipEntries.nextElement();
                    String zipName = zipEntry.getName();

                    if (!zipName.startsWith(fromPath)) {
                        continue;
                    }

                    String pathTail = zipName.substring(fromPath.length());
                    File file = new File(destinationPath + File.separator + pathTail);

                    if (!file.exists()) {
                        if (zipEntry.isDirectory()) {
                            file.mkdir();
                        } else {
                            InputStream inputStream = zipFile.getInputStream(zipEntry);
                            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
                            byte buffer[] = new byte[4096];
                            int count;

                            while ((count = inputStream.read(buffer)) > 0) {
                                outputStream.write(buffer, 0, count);
                            }

                            inputStream.close();
                            outputStream.close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}