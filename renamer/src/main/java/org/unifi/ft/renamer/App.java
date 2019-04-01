package org.unifi.ft.renamer;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.unifi.ft.renamer.gui.MainPanel;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws IOException {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		MainPanel panel = new MainPanel(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
}
