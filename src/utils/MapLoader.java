package utils;

import java.util.HashMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public final class MapLoader {
	
	private TiledMap[][] maps;
	
	/**
	 * Constructor for the MapLoader class, initialises the size of the
	 * internal 2D array to hold the loaded maps.
	 * @param w: The width of the array.
	 * @param h: The height of the array.
	 */
	public MapLoader(int w, int h) {
		maps = new TiledMap[w][h];
	}
	
	/**
	 * Loads a new map from an xml file into an element of the internal
	 * array.
	 * PRE: 0 <= x < width / 0 <= y < height
	 * @param location: a string representing the address of the file
	 * @param x: The x part of the cell's location in the array.
	 * @param y: The corresponding y part.
	 * @throws SlickException
	 */
	public void loadMap(String location, int x, int y) throws SlickException {
		maps[x][y] = new TiledMap(location);
	}
	
	/**
	 * Extracts the properties of each cell in the map to a
	 * Tile.
	 * (This method only pulls out "blocked" and "enemy" properties
	 *  for the moment. Add more as needed.)
	 * PRE: 0 <= x < width / 0 <= y < height
	 * @param x: The x part of the cell's location in the array.
	 * @param y: The corresponding y part.
	 * @return The HashMap of properties.
	 */
	public Tile[][] getProperties(int x, int y) {
		TiledMap cell = maps[x][y];
		int width = cell.getWidth();
		int height = cell.getHeight();
		Tile[][] properties = new Tile[width][height];
		
		//go through all tiles in map
		for (int xAxis = 0; xAxis < width; xAxis++) { 
			for (int yAxis = 0; yAxis < height; yAxis++) {
				int tileID = cell.getTileId(xAxis, yAxis, 0);
				String value = cell.getTileProperty(tileID, "blocked", "false");
				properties[xAxis][yAxis].addProperty("blocked", value); //true or false
				value = cell.getTileProperty(tileID, "enemy", "false");
				properties[xAxis][yAxis].addProperty("enemy", value); //name of enemy, or false
			}
		}
		
		return properties;
	}
}
