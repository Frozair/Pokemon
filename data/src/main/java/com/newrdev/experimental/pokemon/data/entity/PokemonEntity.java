package com.newrdev.experimental.pokemon.data.entity;

import java.util.List;

/**
 * Created by newrdev on 12/30/15.
 */
public class PokemonEntity {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int sp_atk;
    private int sp_def;
    private int speed;
    private int height;
    private int weight;
    private List<PokemonSprite> sprites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSp_atk() {
        return sp_atk;
    }

    public void setSp_atk(int sp_atk) {
        this.sp_atk = sp_atk;
    }

    public int getSp_def() {
        return sp_def;
    }

    public void setSp_def(int sp_def) {
        this.sp_def = sp_def;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonSprite> getSprites() {
        return sprites;
    }

    public void setSprites(List<PokemonSprite> sprites) {
        this.sprites = sprites;
    }

    private final class PokemonSprite {
        private String name;
        private String resource_uri;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResource_uri() {
            return resource_uri;
        }

        public void setResource_uri(String resource_uri) {
            this.resource_uri = resource_uri;
        }
    }
}
