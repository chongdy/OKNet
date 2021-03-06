package ricky.oknet.exception;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import ricky.oknet.utils.Cons;

public class InternalExceptionParser extends ExceptionParser {

    private static final String JsonParseException = "JsonParseException";
    private static final String JsonSyntaxException = "JsonSyntaxException";
    private static final String JSONException = "JSONException";

    @Override
    protected boolean handler(@NonNull Throwable e, @NonNull IHandler handler) {
        String s = !TextUtils.isEmpty(e.getMessage()) ? e.getMessage() : e.getClass().getSimpleName();
        String clzName = e.getClass().getSimpleName();

        if (NumberFormatException.class.isAssignableFrom(e.getClass()) ||
                JsonParseException.equalsIgnoreCase(clzName) ||
                JsonSyntaxException.equalsIgnoreCase(clzName) ||
                JSONException.equalsIgnoreCase(clzName)) {
            handler.onHandler(Cons.Error.Internal, s);
            return true;
        }
        return false;
    }
}
