package org.unifi.ft.renamer.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.unifi.ft.renamer.core.Renamer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainPanel extends Composite {
	private Text fileName;
	private Renamer r;
	private Text directoryName;

	public MainPanel(Shell parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(4, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("Scegli il file excel");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		fileName = new Text(this, SWT.BORDER);
		GridData gd_fileName = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_fileName.widthHint = 233;
		fileName.setLayoutData(gd_fileName);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Button browseFile = new Button(this, SWT.NONE);
		browseFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dd = new FileDialog(parent);
				String file = dd.open();
				if (file != null) {
					// Set the text box to the new selection
					fileName.setText(file);
				}
			}
		});
		browseFile.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		browseFile.setText("Browse");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Label lblScegliLaDirectory = new Label(this, SWT.NONE);
		lblScegliLaDirectory.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblScegliLaDirectory.setText("Scegli la directory dei pdf");
		lblScegliLaDirectory.setAlignment(SWT.CENTER);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		directoryName = new Text(this, SWT.BORDER);
		directoryName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Button browseDirectory = new Button(this, SWT.NONE);
		browseDirectory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dd = new DirectoryDialog(parent);
				String dir = dd.open();
				if (dir != null) {
					// Set the text box to the new selection
					directoryName.setText(dir);
				}
			}
		});
		browseDirectory.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		browseDirectory.setText("Browse");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fileName.getText() != "" && directoryName.getText() != "") {
					String fileText = fileName.getText();
					String directoryText = directoryName.getText();
					r = new Renamer(fileText, directoryText);
					try {
						r.rename();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnNewButton.setText("Rinomina");
	}
}
