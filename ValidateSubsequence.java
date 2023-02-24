import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    
		int seqIndex = 0;
	//	System.out.println("Sequence Size:" + sequence.size());
		for (int i = 0; i < array.size(); i++){
			
		/*	System.out.println("array Index:  " + i + " => " + array.get(i));
			System.out.println("Sequence Index:  " + seqIndex + " => " + sequence.get(seqIndex));
			
		  System.out.println();*/			
			if (array.get(i) == sequence.get(seqIndex)){
				seqIndex++;
			}
			if (seqIndex == sequence.size()){
				return true;
			}
		}
    return false;
  }
}
