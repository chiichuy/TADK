package com.telnor.curso.tadk.fragment;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.R;
import com.telnor.curso.tadk.R.id;
import com.telnor.curso.tadk.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * An activity representing a list of Usuarios. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link UsuarioDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link UsuarioListFragment} and the item details (if present) is a
 * {@link UsuarioDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link UsuarioListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class UsuarioListActivity extends FragmentActivity implements
		UsuarioListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;
	AQuery aq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario_list);
		
		if (findViewById(R.id.usuario_detail_container)  != null) {
			mTwoPane = true;

			((UsuarioListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.usuario_list))
					.setActivateOnItemClick(true);
		}
	}

	/**
	 * Callback method from {@link UsuarioListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(UsuarioDetailFragment.ARG_ITEM_ID, id);
			UsuarioDetailFragment fragment = new UsuarioDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.usuario_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, UsuarioDetailActivity.class);
			detailIntent.putExtra(UsuarioDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
