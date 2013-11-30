package test.mylog.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mylog.dao.AppUser;
import com.mylog.entries.def.EntryTypeDefinition;
import com.mylog.util.HexUtils;


public class TestHexUtils
{
	public static void main (String [] args)
	{
		System.out.println ( HexUtils.bytesToHex(new byte [] {1, 2, 3, (byte)200, (byte)201, (byte)255}) );

		System.out.println (AppUser.getPasswordHash(""));// DF11C3C623C584217D8EA64E8C6FB8A73D7687D7CDBCEB38CDA6E62AECF67A76


		List<EntryTypeDefinition> list = new ArrayList<EntryTypeDefinition>();
		Collections.binarySearch(list, new EntryTypeDefinition("", null, null, null), new Comparator<EntryTypeDefinition>() {
			public int compare(EntryTypeDefinition a, EntryTypeDefinition b)
			{
				return 0;
			}
		});
	}

}
