package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, 
 * it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) 
 * that occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */

public class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) return list;
        HashSet<String> set = new HashSet<String>();
        String pat;
        for (int idx = 0; idx <= s.length() - 10; idx++) {
            pat = s.substring(idx, idx + 10);
            if (set.contains(pat) && !list.contains(pat)) list.add(pat);
            set.add(pat);
        }

        return list;
    }
}
