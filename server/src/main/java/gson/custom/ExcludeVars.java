package gson.custom;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;

/**
 * ExcludeVars
 */
public class ExcludeVars implements ExclusionStrategy {
    private String var_names[];

    public ExcludeVars(String[] var_names) {
        this.var_names = var_names;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        Expose annotation = f.getAnnotation(Expose.class);
        for (String a : var_names) {
            if (a.equals(f.getName())) {
                return false;
            }
            if (annotation == null || !annotation.serialize() || !annotation.deserialize()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
