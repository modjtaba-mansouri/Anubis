package com.anubis;

import android.os.Bundle;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Android 15+ enforces edge-to-edge with no opt-out, so the WebView draws
    // under the status bar / nav bar by default. Pad the WebView's PARENT
    // container by the real system bar insets so app content never sits
    // under them. (Padding the parent, not the WebView itself, is what
    // actually receives the dispatched insets reliably.)
    WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    View webViewParent = (View) getBridge().getWebView().getParent();
    ViewCompat.setOnApplyWindowInsetsListener(webViewParent, (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
      Insets ime = insets.getInsets(WindowInsetsCompat.Type.ime());
      boolean keyboardVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
      v.setPadding(
        systemBars.left,
        systemBars.top,
        systemBars.right,
        keyboardVisible ? ime.bottom : systemBars.bottom
      );
      return new WindowInsetsCompat.Builder(insets)
        .setInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout(), Insets.of(0, 0, 0, 0))
        .build();
    });
    ViewCompat.requestApplyInsets(webViewParent);
  }
}
