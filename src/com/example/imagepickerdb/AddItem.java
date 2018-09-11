package com.example.imagepickerdb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddItem extends Activity implements OnClickListener {
	
	ImageView iv;
	EditText txtName;
	Button btnCancel, btnOkey;
	private Uri uriImage;
	String name;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.additem);
		
		this.iv=(ImageView) this.findViewById(R.id.imageView1);
		this.txtName=(EditText) this.findViewById(R.id.editText1);
		this.btnCancel=(Button) this.findViewById(R.id.button1);
		this.btnOkey=(Button) this.findViewById(R.id.button2);
		
		this.iv.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);
		this.btnOkey.setOnClickListener(this);
		
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null){
			uriImage=b.getParcelable("image");
			name=b.getString("name");
			
			this.iv.setImageURI(uriImage);
			this.txtName.setText(name);
			
			
		}
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		int id=arg0.getId();
		switch(id){
		case R.id.imageView1:
			
			Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			this.startActivityForResult(intent, 100);
			
			break;
		case R.id.button2:
			String name=this.txtName.getText().toString();
			
			if(!name.equals("") && uriImage!=null){
				Intent n = new Intent();
				n.putExtra("image", this.uriImage);
				n.putExtra("name", name);
				this.setResult(Activity.RESULT_OK,n);
			}
			else Toast.makeText(this, "Please choose image and put text", Toast.LENGTH_SHORT).show();
			
			
			//break;
		case R.id.button1:
			this.finish();
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		uriImage = data.getData();
		this.iv.setImageURI(uriImage);
		
	}
	
	

}
