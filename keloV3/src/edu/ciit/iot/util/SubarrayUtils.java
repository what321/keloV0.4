package edu.ciit.iot.util;

/**
 * Code shared to do searches
 */
public class SubarrayUtils {

    // boolean IndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by boolean array to do searches. The
     * source is the boolean array being searched, and the target
     * is the boolean array being searched for.
     *
     * @param   source       the boolean array being searched.
     * @param   sourceOffset offset of the source boolean array.
     * @param   sourceCount  count of the source boolean array.
     * @param   target       the boolean array being searched for.
     * @param   targetOffset offset of the target boolean array.
     * @param   targetCount  count of the target boolean array.
     */
    public static int indexOf(boolean[] source, int sourceOffset, int sourceCount,
                              boolean[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by boolean array to do searches. The
     * source is the boolean array being searched, and the target
     * is the boolean array being searched for.
     *
     * @param   source       the boolean array being searched.
     * @param   sourceOffset offset of the source boolean array.
     * @param   sourceCount  count of the source boolean array.
     * @param   target       the boolean array being searched for.
     * @param   targetOffset offset of the target boolean array.
     * @param   targetCount  count of the target boolean array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(boolean[] source, int sourceOffset, int sourceCount,
                       boolean[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        boolean first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // boolean LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by boolean array to do searches. The
     * source is the boolean array being searched, and the target
     * is the boolean array being searched for.
     *
     * @param   source       the boolean array being searched.
     * @param   sourceOffset offset of the source boolean array.
     * @param   sourceCount  count of the source boolean array.
     * @param   target       the boolean array being searched for.
     * @param   targetOffset offset of the target boolean array.
     * @param   targetCount  count of the target boolean array.
     */
    public static int lastIndexOf(boolean[] source, int sourceOffset, int sourceCount,
                                  boolean[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by byte array to do searches. The
     * source is the byte array being searched, and the target
     * is the byte array being searched for.
     *
     * @param   source       the boolean array being searched.
     * @param   sourceOffset offset of the source boolean array.
     * @param   sourceCount  count of the source boolean array.
     * @param   target       the boolean array being searched for.
     * @param   targetOffset offset of the target boolean array.
     * @param   targetCount  count of the target boolean array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(boolean[] source, int sourceOffset, int sourceCount,
                           boolean[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        boolean arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // char IndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by char array to do searches. The
     * source is the char array being searched, and the target
     * is the char array being searched for.
     *
     * @param   source       the char array being searched.
     * @param   sourceOffset offset of the source char array.
     * @param   sourceCount  count of the source char array.
     * @param   target       the char array being searched for.
     * @param   targetOffset offset of the target char array.
     * @param   targetCount  count of the target char array.
     */
    public static int indexOf(char[] source, int sourceOffset, int sourceCount,
                              char[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by char array to do searches. The
     * source is the char array being searched, and the target
     * is the char array being searched for.
     *
     * @param   source       the char array being searched.
     * @param   sourceOffset offset of the source char array.
     * @param   sourceCount  count of the source char array.
     * @param   target       the char array being searched for.
     * @param   targetOffset offset of the target char array.
     * @param   targetCount  count of the target char array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // char LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by char array to do searches. The
     * source is the char array being searched, and the target
     * is the char array being searched for.
     *
     * @param   source       the char array being searched.
     * @param   sourceOffset offset of the source char array.
     * @param   sourceCount  count of the source char array.
     * @param   target       the char array being searched for.
     * @param   targetOffset offset of the target char array.
     * @param   targetCount  count of the target char array.
     */
    public static int lastIndexOf(char[] source, int sourceOffset, int sourceCount,
                                  char[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by char array to do searches. The
     * source is the char array being searched, and the target
     * is the char array being searched for.
     *
     * @param   source       the char array being searched.
     * @param   sourceOffset offset of the source char array.
     * @param   sourceCount  count of the source char array.
     * @param   target       the char array being searched for.
     * @param   targetOffset offset of the target char array.
     * @param   targetCount  count of the target char array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(char[] source, int sourceOffset, int sourceCount,
                           char[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        char arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // byte IndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by byte array to do searches. The
     * source is the byte array being searched, and the target
     * is the byte array being searched for.
     *
     * @param   source       the byte array being searched.
     * @param   sourceOffset offset of the source byte array.
     * @param   sourceCount  count of the source byte array.
     * @param   target       the byte array being searched for.
     * @param   targetOffset offset of the target byte array.
     * @param   targetCount  count of the target byte array.
     */
    public static int indexOf(byte[] source, int sourceOffset, int sourceCount,
                              byte[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by byte array to do searches. The
     * source is the byte array being searched, and the target
     * is the byte array being searched for.
     *
     * @param   source       the byte array being searched.
     * @param   sourceOffset offset of the source byte array.
     * @param   sourceCount  count of the source byte array.
     * @param   target       the byte array being searched for.
     * @param   targetOffset offset of the target byte array.
     * @param   targetCount  count of the target byte array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(byte[] source, int sourceOffset, int sourceCount,
                       byte[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        byte first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // byte LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by byte array to do searches. The
     * source is the byte array being searched, and the target
     * is the byte array being searched for.
     *
     * @param   source       the byte array being searched.
     * @param   sourceOffset offset of the source byte array.
     * @param   sourceCount  count of the source byte array.
     * @param   target       the byte array being searched for.
     * @param   targetOffset offset of the target byte array.
     * @param   targetCount  count of the target byte array.
     */
    public static int lastIndexOf(byte[] source, int sourceOffset, int sourceCount,
                                  byte[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by byte array to do searches. The
     * source is the byte array being searched, and the target
     * is the byte array being searched for.
     *
     * @param   source       the byte array being searched.
     * @param   sourceOffset offset of the source byte array.
     * @param   sourceCount  count of the source byte array.
     * @param   target       the byte array being searched for.
     * @param   targetOffset offset of the target byte array.
     * @param   targetCount  count of the target byte array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(byte[] source, int sourceOffset, int sourceCount,
                           byte[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        byte arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // short IndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by short array to do searches. The
     * source is the short array being searched, and the target
     * is the short array being searched for.
     *
     * @param   source       the short array being searched.
     * @param   sourceOffset offset of the source short array.
     * @param   sourceCount  count of the source short array.
     * @param   target       the short array being searched for.
     * @param   targetOffset offset of the target short array.
     * @param   targetCount  count of the target short array.
     */
    public static int indexOf(short[] source, int sourceOffset, int sourceCount,
                              short[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by short array to do searches. The
     * source is the short array being searched, and the target
     * is the short array being searched for.
     *
     * @param   source       the short array being searched.
     * @param   sourceOffset offset of the source short array.
     * @param   sourceCount  count of the source short array.
     * @param   target       the short array being searched for.
     * @param   targetOffset offset of the target short array.
     * @param   targetCount  count of the target short array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(short[] source, int sourceOffset, int sourceCount,
                       short[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        short first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // short LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by short array to do searches. The
     * source is the short array being searched, and the target
     * is the short array being searched for.
     *
     * @param   source       the short array being searched.
     * @param   sourceOffset offset of the source short array.
     * @param   sourceCount  count of the source short array.
     * @param   target       the short array being searched for.
     * @param   targetOffset offset of the target short array.
     * @param   targetCount  count of the target short array.
     */
    public static int lastIndexOf(short[] source, int sourceOffset, int sourceCount,
                                  short[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by short array to do searches. The
     * source is the short array being searched, and the target
     * is the short array being searched for.
     *
     * @param   source       the short array being searched.
     * @param   sourceOffset offset of the source short array.
     * @param   sourceCount  count of the source short array.
     * @param   target       the short array being searched for.
     * @param   targetOffset offset of the target short array.
     * @param   targetCount  count of the target short array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(short[] source, int sourceOffset, int sourceCount,
                           short[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        short arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // int IndexOf
    // -------------------------------------------------------------------------------------------- 
    /**
     * Code shared by int array to do searches. The
     * source is the int array being searched, and the target
     * is the int array being searched for.
     *
     * @param   source       the int array being searched.
     * @param   sourceOffset offset of the source int array.
     * @param   sourceCount  count of the source int array.
     * @param   target       the int array being searched for.
     * @param   targetOffset offset of the target int array.
     * @param   targetCount  count of the target int array.
     */
    public static int indexOf(int[] source, int sourceOffset, int sourceCount,
                              int[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by int array to do searches. The
     * source is the int array being searched, and the target
     * is the int array being searched for.
     *
     * @param   source       the int array being searched.
     * @param   sourceOffset offset of the source int array.
     * @param   sourceCount  count of the source int array.
     * @param   target       the int array being searched for.
     * @param   targetOffset offset of the target int array.
     * @param   targetCount  count of the target int array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(int[] source, int sourceOffset, int sourceCount,
                       int[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        int first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // int LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by int array to do searches. The
     * source is the int array being searched, and the target
     * is the int array being searched for.
     *
     * @param   source       the int array being searched.
     * @param   sourceOffset offset of the source int array.
     * @param   sourceCount  count of the source int array.
     * @param   target       the int array being searched for.
     * @param   targetOffset offset of the target int array.
     * @param   targetCount  count of the target int array.
     */
    public static int lastIndexOf(int[] source, int sourceOffset, int sourceCount,
                                  int[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by int array to do searches. The
     * source is the int array being searched, and the target
     * is the int array being searched for.
     *
     * @param   source       the int array being searched.
     * @param   sourceOffset offset of the source int array.
     * @param   sourceCount  count of the source int array.
     * @param   target       the int array being searched for.
     * @param   targetOffset offset of the target int array.
     * @param   targetCount  count of the target int array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(int[] source, int sourceOffset, int sourceCount,
                           int[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        int arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // long IndexOf
    // -------------------------------------------------------------------------------------------- 
    /**
     * Code shared by long array to do searches. The
     * source is the long array being searched, and the target
     * is the long array being searched for.
     *
     * @param   source       the long array being searched.
     * @param   sourceOffset offset of the source long array.
     * @param   sourceCount  count of the source long array.
     * @param   target       the long array being searched for.
     * @param   targetOffset offset of the target long array.
     * @param   targetCount  count of the target long array.
     */
    public static int indexOf(long[] source, int sourceOffset, int sourceCount,
                              long[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by long array to do searches. The
     * source is the long array being searched, and the target
     * is the long array being searched for.
     *
     * @param   source       the long array being searched.
     * @param   sourceOffset offset of the source long array.
     * @param   sourceCount  count of the source long array.
     * @param   target       the long array being searched for.
     * @param   targetOffset offset of the target long array.
     * @param   targetCount  count of the target long array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(long[] source, int sourceOffset, int sourceCount,
                       long[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        long first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // long LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by long array to do searches. The
     * source is the long array being searched, and the target
     * is the long array being searched for.
     *
     * @param   source       the long array being searched.
     * @param   sourceOffset offset of the source long array.
     * @param   sourceCount  count of the source long array.
     * @param   target       the long array being searched for.
     * @param   targetOffset offset of the target long array.
     * @param   targetCount  count of the target long array.
     */
    public static int lastIndexOf(long[] source, int sourceOffset, int sourceCount,
                                  long[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by long array to do searches. The
     * source is the long array being searched, and the target
     * is the long array being searched for.
     *
     * @param   source       the long array being searched.
     * @param   sourceOffset offset of the source long array.
     * @param   sourceCount  count of the source long array.
     * @param   target       the long array being searched for.
     * @param   targetOffset offset of the target long array.
     * @param   targetCount  count of the target long array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(long[] source, int sourceOffset, int sourceCount,
                           long[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        long arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // float IndexOf
    // -------------------------------------------------------------------------------------------- 
    /**
     * Code shared by float array to do searches. The
     * source is the float array being searched, and the target
     * is the float array being searched for.
     *
     * @param   source       the float array being searched.
     * @param   sourceOffset offset of the source float array.
     * @param   sourceCount  count of the source float array.
     * @param   target       the float array being searched for.
     * @param   targetOffset offset of the target float array.
     * @param   targetCount  count of the target float array.
     */
    public static int indexOf(float[] source, int sourceOffset, int sourceCount,
                              float[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by float array to do searches. The
     * source is the float array being searched, and the target
     * is the float array being searched for.
     *
     * @param   source       the float array being searched.
     * @param   sourceOffset offset of the source float array.
     * @param   sourceCount  count of the source float array.
     * @param   target       the float array being searched for.
     * @param   targetOffset offset of the target float array.
     * @param   targetCount  count of the target float array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(float[] source, int sourceOffset, int sourceCount,
                       float[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        float first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // float LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by float array to do searches. The
     * source is the float array being searched, and the target
     * is the float array being searched for.
     *
     * @param   source       the float array being searched.
     * @param   sourceOffset offset of the source float array.
     * @param   sourceCount  count of the source float array.
     * @param   target       the float array being searched for.
     * @param   targetOffset offset of the target float array.
     * @param   targetCount  count of the target float array.
     */
    public static int lastIndexOf(float[] source, int sourceOffset, int sourceCount,
                                  float[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by float array to do searches. The
     * source is the float array being searched, and the target
     * is the float array being searched for.
     *
     * @param   source       the float array being searched.
     * @param   sourceOffset offset of the source float array.
     * @param   sourceCount  count of the source float array.
     * @param   target       the float array being searched for.
     * @param   targetOffset offset of the target float array.
     * @param   targetCount  count of the target float array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(float[] source, int sourceOffset, int sourceCount,
                           float[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        float arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }




    // double IndexOf
    // -------------------------------------------------------------------------------------------- 
    /**
     * Code shared by double array to do searches. The
     * source is the double array being searched, and the target
     * is the double array being searched for.
     *
     * @param   source       the double array being searched.
     * @param   sourceOffset offset of the source double array.
     * @param   sourceCount  count of the source double array.
     * @param   target       the double array being searched for.
     * @param   targetOffset offset of the target double array.
     * @param   targetCount  count of the target double array.
     */
    public static int indexOf(double[] source, int sourceOffset, int sourceCount,
                              double[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by double array to do searches. The
     * source is the double array being searched, and the target
     * is the double array being searched for.
     *
     * @param   source       the double array being searched.
     * @param   sourceOffset offset of the source double array.
     * @param   sourceCount  count of the source double array.
     * @param   target       the double array being searched for.
     * @param   targetOffset offset of the target double array.
     * @param   targetCount  count of the target double array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(double[] source, int sourceOffset, int sourceCount,
                       double[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        double first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    
    // double LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by double array to do searches. The
     * source is the double array being searched, and the target
     * is the double array being searched for.
     *
     * @param   source       the double array being searched.
     * @param   sourceOffset offset of the source double array.
     * @param   sourceCount  count of the source double array.
     * @param   target       the double array being searched for.
     * @param   targetOffset offset of the target double array.
     * @param   targetCount  count of the target double array.
     */
    public static int lastIndexOf(double[] source, int sourceOffset, int sourceCount,
                                  double[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by double array to do searches. The
     * source is the double array being searched, and the target
     * is the double array being searched for.
     *
     * @param   source       the double array being searched.
     * @param   sourceOffset offset of the source double array.
     * @param   sourceCount  count of the source double array.
     * @param   target       the double array being searched for.
     * @param   targetOffset offset of the target double array.
     * @param   targetCount  count of the target double array.
     * @param   fromIndex    the index to begin searching from.
     */
    static int lastIndexOf(double[] source, int sourceOffset, int sourceCount,
                           double[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        double arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }



    // Object IndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by array to do searches. The
     * source is the array being searched, and the target
     * is the array being searched for.
     *
     * @param   source       the array being searched.
     * @param   sourceOffset offset of the source array.
     * @param   sourceCount  count of the source array.
     * @param   target       the array being searched for.
     * @param   targetOffset offset of the target array.
     * @param   targetCount  count of the target array.
     */
    public static <T> int indexOf(T[] source, int sourceOffset, int sourceCount,
                                  T[] target, int targetOffset, int targetCount) {
        
        return indexOf(source, sourceOffset, sourceCount, 
                       target, targetOffset, targetCount, 0);
    }
    
    /**
     * Code shared by array to do searches. The
     * source is the array being searched, and the target
     * is the array being searched for.
     *
     * @param   source       the array being searched.
     * @param   sourceOffset offset of the source array.
     * @param   sourceCount  count of the source array.
     * @param   target       the array being searched for.
     * @param   targetOffset offset of the target array.
     * @param   targetCount  count of the target byte array.
     * @param   fromIndex    the index to begin searching from.
     */
    static <T> int indexOf(T[] source, int sourceOffset, int sourceCount,
                           T[] target, int targetOffset, int targetCount, int fromIndex) {
        
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        T first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

    // Object LastIndexOf
    // --------------------------------------------------------------------------------------------
    /**
     * Code shared by array to do searches. The
     * source is the array being searched, and the target
     * is the array being searched for.
     *
     * @param   source       the array being searched.
     * @param   sourceOffset offset of the source array.
     * @param   sourceCount  count of the source array.
     * @param   target       the array being searched for.
     * @param   targetOffset offset of the target array.
     * @param   targetCount  count of the target array.
     */
    public static <T> int lastIndexOf(T[] source, int sourceOffset, int sourceCount,
                                      T[] target, int targetOffset, int targetCount) {
        
        return lastIndexOf(source, sourceOffset, sourceCount, 
                           target, targetOffset, targetCount, sourceOffset + sourceCount);
    }
    
    /**
     * Code shared by array to do searches. The
     * source is the array being searched, and the target
     * is the array being searched for.
     *
     * @param   source       the array being searched.
     * @param   sourceOffset offset of the source array.
     * @param   sourceCount  count of the source array.
     * @param   target       the array being searched for.
     * @param   targetOffset offset of the target array.
     * @param   targetCount  count of the target array.
     * @param   fromIndex    the index to begin searching from.
     */
    static <T> int lastIndexOf(T[] source, int sourceOffset, int sourceCount,
                               T[] target, int targetOffset, int targetCount, int fromIndex) {
        /*
         * Check arguments; return immediately where possible. For
         * consistency, don't check for null str.
         */
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0) {
            return fromIndex;
        }
        int arrLastIndex = targetOffset + targetCount - 1;
        T arrLastItem = target[arrLastIndex];
        int min = sourceOffset + targetCount - 1;
        int i = min + fromIndex;

    startSearchForLastItem:
        while (true) {
            while (i >= min && source[i] != arrLastItem) {
                i--;
            }
            if (i < min) {
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = arrLastIndex - 1;
            while (j > start) {
                if (source[j--] != target[k--]) {
                    i--;
                    continue startSearchForLastItem;
                }
            }
            return start - sourceOffset + 1;
        }
    }

}
