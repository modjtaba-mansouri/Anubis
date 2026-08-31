package com.anubis;

import android.os.Bundle;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Android 15+ enforces edge-to-edge with no opt-out, so the WebView draws
    // under the status bar / nav bar by default. Pad the WebView itself by the
    // real system bar insets so app content never sits under them.
    ViewCompat.setOnApplyWindowInsetsListener(getBridge().getWebView(), (view, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });
  }
}
