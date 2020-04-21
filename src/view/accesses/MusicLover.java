package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.AccessLevel;
import view.Title;

public class MusicLover extends Title{

	private AccessLevel ML_level;
	private Title MusicLoverTitle = new MusicLover();
	private Collection<MusicLover> MLTitles = new ArrayList<>();
	
	public MusicLover() {
	ML_level = AccessLevel.MUSICLOVER;
	String a = ML_level.getLevel();
//	Title title = new MusicLover();
//	title.setAccessLevel(level);
//	System.out.println(title.getAccessLevel());
	}
	
	public void musicOrLive() {
		
		
	}
}
