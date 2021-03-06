/*
 *  Copyright (c) Facebook, Inc.
 *
 *  This source code is licensed under the MIT license found in the LICENSE
 *  file in the root directory of this source tree.
 *
 */
package com.facebook.flipper.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.facebook.flipper.android.AndroidFlipperClient;
import com.facebook.flipper.core.FlipperClient;
import com.facebook.flipper.plugins.example.ExampleFlipperPlugin;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final ComponentContext c = new ComponentContext(this);
    setContentView(LithoView.create(c, RootComponent.create(c).build()));

    final FlipperClient client = AndroidFlipperClient.getInstanceIfInitialized();
    if (client != null) {
      final ExampleFlipperPlugin samplePlugin = client.getPluginByClass(ExampleFlipperPlugin.class);
      samplePlugin.setActivity(this);
    }
  }
}
