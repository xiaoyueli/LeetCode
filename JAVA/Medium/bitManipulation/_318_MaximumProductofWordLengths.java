package bitManipulation;

// 位操作检查两个字符串是否有重叠字符ß

import java.util.Arrays;
import java.util.Comparator;

public class _318_MaximumProductofWordLengths {
	
    public int maxProduct(String[] words) {
        
        Comparator<String> myCom = new Comparator<String>() {
            public int compare(String s1, String s2) {
                int len1 = s1.length();
                int len2 = s2.length();
                if (len1 > len2) return -1;
                if (len1 < len2) return 1;
                return 0;
            }
        };
        
        Arrays.sort(words, myCom);
        
        int len = words.length;
        
        for (int i = 1; i < len; i++) {
            String sec = words[i];
            
            for (int j = 0; j < i; j++) {
                String fir = words[j];
                
                boolean res = isValid(sec, fir);
                System.out.println(res + ":  " + j + " " + fir + "    " + i + " " + sec);
                if (res) return sec.length() * fir.length();
            }    
        }
        
        return 0;
        
    }
    
    private boolean isValid(String s1, String s2) {
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int[] count = new int[26];
        
        for (char c: arr1) {
            count[c - 'a']++;
        }
        
        for (char c: arr2) {
            if (count[c - 'a'] != 0) return false;
        }
        
        return true;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_318_MaximumProductofWordLengths test = new _318_MaximumProductofWordLengths();
//		String[] data = new String[]{"ccd","accaceddeeeaefc","bcaffa","bbcfafbb","accacfebbabbeedfbfdb","beddecbffcdaededdaefdedfdea","cf","ddafdcbd","bbafacebacaefdaffccebddff","ebccffcddbeddccacceccaec","becfbfdccdfdeadfbfaddbcded","cbabeaaeabefedbaeaedc","dfadbbdbead","cafaefdcd","eccdbfceafeeeacfcddc","dbabbcdbb","abfbfbffcbebde","cfaadaa","fc","faebcabb","adbacebabcaaccbdeaffff","aeaefccf","dbacbeeabdbcdfccabebaecfef","ecdadeefcaddffaececffa","defcabf","abbcecbccbdaebaecaefabed","dfeeebcbaaefc","aecccbcbbdddb","dcfabacec","fccfbacbacddeaaea","dfdbfacbacbecb","cbfeebdbfecb","cffaacacbde","aafd","bdcebbbebd","afeffadcfcdacfba","dafeefbcdfaffcfacee","dcbbebfbedafedcdbab","cafaf","bcbcccfdebdd","efaaaacccff","cffbead","ebcfccfcddffdec","fffdfdcec","beeafefbdfa","cdfdbccfbaaeffcabab","ddadcbabbcb","decfaeabbecebaebeaddedae","cdcbfffbebae","aeccefcbcbbddfdc","ffefedaf","cddbabccafaffeafeedcbedbdad","eddeeccfedcefadfdfebfacb","aca","ffdcafaddcddf","ef","bbbbffe","ffccfebabaadcffacbbb","cbdeddfddffacbeeeebafebabda","ddeecb","cffdc","edcffcebadf","becbcadcafddcfbbeeddbfffcab","abcbaceeaeaddd","cfeffceebfaeefadaaccfa","eaccddb","caeafbfafecd","becaafdbaadbfecfdfde","ecabaaeafbfbcbadaac","bdcdffcfaeebeedfdfddfaf","dbbfbaeecbfcdebad","cceecddeeecdbde","beec","adbcfdbfdbccdcffffbcffbec","bbbbfe","cdaedaeaad","dadbfeafadd","fcacaaebcedfbfbcddfc","ceecfedceac","dada","ccfdaeffbcfcc","eadddbbbdfa","beb","fcaaedadabbbeacabefdabe","dfcddeeffbeec","defbdbeffebfceaedffbfee","cffadadfbaebfdbadebc","fbbadfccbeffbdeabecc","bdabbffeefeccb","bdeeddc","afcbacdeefbcecff","cfeaebbbadacbced","edfddfedbcfecfedb","faed","cbcdccfcbdebabc","efb","dbddadfcddbd","fbaefdfebeeacbdfbdcdddcbefc","cbbfaccdbffde","adbcabaffebdffad"};
//		test.maxProduct(data);
		System.out.println(123 ^ 321);
	}

}
