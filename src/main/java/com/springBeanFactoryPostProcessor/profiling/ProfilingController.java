package com.springBeanFactoryPostProcessor.profiling;

/**
 * Class for control enable profiling.
 */
public class ProfilingController {

    // switch on profiling
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
