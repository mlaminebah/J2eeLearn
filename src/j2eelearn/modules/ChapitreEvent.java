package j2eelearn.modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import j2eelearn.utils.Utils;

public interface ChapitreEvent {
	public JPanel getNorth ();
	public JPanel getSouth ();
    public JPanel getLessonsPane ();
    public JPanel getTpsPane ();
    public void effectLessons (String chap);
    //TDO: cliq tps
    public void effectTps (String chap);
}
