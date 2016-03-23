package Fonctions;

public class FCT_PathUtils {
    public static String ExpandFileName(String baseName, String fileName) {
        String result;
        String tmpFileName = fileName;
        boolean error = false; 
        
        if (tmpFileName.indexOf(FCT_Ressources.LECT_DELIMITER) == 1) result = tmpFileName; //fileName est un chemin absolu, on le renvoie tel quel
        else {
            result = IncludeTrailingPathDelimiter(baseName);
            while (tmpFileName.startsWith(FCT_Ressources.BACK_PARENT_FOLDER) && (!error)) {
                if (result.endsWith(FCT_Ressources.LECT_DELIMITER)) {
                    error = true;
                }
                else {
                    result = ExcludeTrailingPathDelimiter(result);
                    result = result.substring(0, result.lastIndexOf(FCT_Ressources.PATH_DELIMITER) + 1);
                    tmpFileName = tmpFileName.substring(2, tmpFileName.length());
                    if (tmpFileName.startsWith(FCT_Ressources.PATH_DELIMITER)) tmpFileName = tmpFileName.substring(1, tmpFileName.length());
                }
            }
            
            if (error) result = fileName;
            else result += tmpFileName;
        }
        
        return result;
    }
    
    public static String IncludeTrailingPathDelimiter(String baseName) {
        String result = baseName;
        if (!baseName.endsWith(FCT_Ressources.PATH_DELIMITER)) result = baseName + FCT_Ressources.PATH_DELIMITER;
        return result;
    }
    
    public static String ExcludeTrailingPathDelimiter(String baseName) {
        String result = baseName;
        if (baseName.endsWith(FCT_Ressources.PATH_DELIMITER)) result = result.substring(0, result.length() - 1);
        return result;
    }
    
    public static String ExtractDirName(String fileName) {
        String result = fileName;
        result = result.substring(0, result.lastIndexOf(FCT_Ressources.PATH_DELIMITER));
        return result;
    }
    
    public static String ExtractFilePath(String fileName) {
        return IncludeTrailingPathDelimiter(ExtractDirName(fileName));
    }
    
    public static String ExtractFileName(String fileName) {
        String result = fileName;
        result = result.substring(result.lastIndexOf(FCT_Ressources.PATH_DELIMITER) + 1, result.length());
        return result;
    }
    
    public static String ExtractFileExt(String fileName) {
        String result = fileName;
        result = result.substring(result.lastIndexOf(FCT_Ressources.EXT_DELIMITER) + 1, result.length());
        return result;
    }
    
    public static String ChangeFileExt(String fileName, String extension) {
        String result  = fileName;
        result = result.substring(0, result.lastIndexOf(FCT_Ressources.EXT_DELIMITER));
        result += extension;
        return result;
    }
}
