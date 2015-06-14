package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase {

    public ProcessHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    private Process process;

    public void startApplicationUnderTest() throws IOException {
        String command = manager.getProperty("app.path");
        process = Runtime.getRuntime().exec(command);
    }

    public void stopApplicationUnderTest() {
        process.destroy();
    }
}
