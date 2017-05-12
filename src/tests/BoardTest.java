package tests;

import game.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by pekka on 11/05/2017.
 */

class BoardTest {

    @Test
    void set() {
        Board b=new Board(100,100);
        b.set(0,0);
        assertEquals(b.isSet(0,0),true);
    }

    @Test
    void unset() {
        Board b=new Board(100,100);
        b.set(0,0);
        assertEquals(b.isSet(0,0),true);
        b.unset(0,0);
        assertEquals(b.isSet(0,0),false);
    }

    @Test
    void isSet() {
        Board b=new Board(100,100);
        b.set(0,0);
        assertTrue(b.isSet(0,0));
    }

    @Test
    void clear() {
        Board b=new Board(10,10);
        b.set(0,0);
        b.clear();
        assertFalse(b.isSet(0,0));
    }

    @org.junit.jupiter.api.Test
    void getBoardWidth() {
        Board b=new Board(100,100);
        assert (b.getBoardWidth()==100);
    }

    @org.junit.jupiter.api.Test
    void getBoardHeight() {
        Board b=new Board(100,100);
        assert (b.getBoardHeight()==100);
    }

    @org.junit.jupiter.api.Test
    void testToString(){
        Board b=new Board(5,1);
        b.clear();
        String assume="00000";
        assertEquals(assume,b.toString());
    }

}