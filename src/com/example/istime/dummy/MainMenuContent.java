package com.example.istime.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class MainMenuContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<MenuItem> ITEMS = new ArrayList<MenuItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

	static {
		// Add 3 sample items.
		addItem(new MenuItem("Profile", "Profile"));
		addItem(new MenuItem("Calendar", "Calendar"));
		addItem(new MenuItem("Summary", "Summary"));
	}

	private static void addItem(MenuItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class MenuItem {
		public String id;
		public String content;

		public MenuItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
