package paoo.Game;
import paoo.Items.Item;
import paoo.Items.Monster;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Game implements Runnable {
    Board b;
    Thread t=null;
    Menu Meniu;
    boolean waiting=false;

    public Game(Board b,Menu a)
    {
        this.b=b;
        this.Meniu=a;
    }
    public void start()
    {

        SetMenu(true);

    }

    public void run(){

        while(true)
        {

                long timestart=System.currentTimeMillis();
                if(!waiting) {
                    Update();
                    render();
                }
                long timeframe=System.currentTimeMillis()-timestart;
                int delay=1000/60;
                if(timeframe<delay)
                {
                    try{
                        sleep(delay-timeframe);
                    }catch(Exception e){System.out.println("Frame time Exception");}
                }

        }
    }

    //Global update function
    public synchronized void Update(){
        b.Update();
        if(b.GetChangeLvl())
        {
            b.ChangeLevel(b.GetNextLevel());
            b.SetChangeLvl(false);
            b.RemoveItems();
            b.AddItems();
        }else
        {
            b.RemoveItems();
            b.AddItems();
            for(Item a:b.GetItems()){
                a.Update();
            }
        }

    }


    //Renders the items stored in "items" ArrayList from curent game board;
    public synchronized void render(){
        b.repaint();
    }

    public void SetMenu(Boolean menu){
        if(menu){
            Meniu.setVisible(true);
            b.setVisible(false);
            waiting=true;

        }else{
            Meniu.setVisible(false);
            b.setVisible(true);
        }
    }

    public void NewGame(){
        if(t!=null)
        {
                b.ClearBoard();
                b.setVisible(true);
                b.requestFocus();
                SetMenu(false);
                waiting = false;

        }
        else{
            t=new Thread(this);
            b.initBoard();
            t.start();
            b.setVisible(true);
            b.requestFocus();
            SetMenu(false);
            waiting=false;
        }


    }

    public void Continue(){
        SetMenu(false);
        b.setVisible(true);
        b.requestFocus();
        waiting=false;


    }
}
