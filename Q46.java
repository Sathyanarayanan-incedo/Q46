import java.util.*;
public class Anagrams {
	static class Words {
		String str; 
		int index; 
		Words(String str, int idx)
		{
			this.str = str;
			this.index = idx;
		}
	}
	static class DuplicateArray {
		Words[] array; 
		int size; 
		public DuplicateArray(String str[], int size)
		{
			this.size = size;
			array = new Words[size];
			for (int i = 0; i < size; ++i) {
				array[i] = new Words(str[i], i);
			}
		}
	}
	static class compStr implements Comparator<Words> {
		public int compare(Words a, Words b)
		{
			return a.str.compareTo(b.str);
		}
	}

	static void print_Anagrams(String strs[],
									int size)
	{
		DuplicateArray duplicateArray = new DuplicateArray(strs, size);
		for (int i = 0; i < size; ++i) {
			char[] char_arr
				= duplicateArray.array[i].str.toCharArray();
			Arrays.sort(char_arr);
			duplicateArray.array[i].str = new String(char_arr);
		}
		for (int i = 0; i < size; ++i)
			System.out.print(
				strs[duplicateArray.array[i].index] + " ");
	}
	public static void main(String args[])
	{
		String strs[]
			= { "eat","tea","tan","ate","nat","bat" };
		int size = strs.length;
		print_Anagrams(strs, size);
	}
}
