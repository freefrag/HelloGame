package entities;

import org.newdawn.slick.Input;
import utils.Tile;

public interface IEntity extends Cloneable {
	float FRICTION = 0.98f;
	float GRAVITY = 0.09f;
	
	/**
	 * Returns the current x-position of this entity.
	 */
	float getX();
	
	/**
	 * Returns the current y-position of this entity.
	 */
	float getY();
	
	/**
	 * Returns the width of the hitbox of this entity.
	 */
	float getWidth();
	
	/**
	 * Returns the height of the hitbox of this entity;
	 */
	float getHeight();
	
	
	/**
	 * Reduces this entity's health by an amount influenced by the argument provided according to some formula.
	 * @param normalDamage The damage dealt normally ignoring special hits and armour effects etc...
	 * @return The actual amount of damage taken by this entity.
	 */
	int takeDamage(int normalDamage);
	
	/**
	 * Returns the amount of damage done by this entity when taking into account critical hits etc...
	 */
	int getDamage();
	
	/**
	 * Returns the normal damage (excluding critical hits etc...) done by this entity. 
	 */
	int getNormalDamage();
	
	/**
	 * Returns the absolute value of this entity's current health.
	 */
	int getHealth();
	
	/**
	 * Returns a float value in the range [0.0 - 1.0] inclusive representing the entity's current health.
	 */
	float getHealthPercent();
	
	/**
	 * Returns the absolute value of this entity's maximum possible health.
	 */
	int getMaxHealth();
	
	/**
	 * Moves this entity by it's current velocity values and applies constants such as friction and gravity.
	 * @param delta The time in microseconds since the last frame update.
	 */
	void frameMove(int delta);
	
	/**
	 * Returns true if and only if this entity has an absolute health equal to zero.
	 */
	boolean isDead();
	
	/**
	 * returns whether the entity is touching the ground
	 * @return
	 */
	boolean isOnGround();
	
	void jump();
	
	void update(Input input, Tile[][] properties, int delta);
	
	void render();
}
