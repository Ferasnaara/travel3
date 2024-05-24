package com.example.traviling.Add;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.traviling.LoginSignUpForgetPassword.FirebaseServices;
import com.example.traveling.R;
import com.example.traviling.Traveling;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;


    public class AddTravilingFragment extends Fragment {
        private static final int GALLERY_REQUEST_CODE = 123;
        private FirebaseServices fbs;
        private EditText etName, etDescription, etAddress, etPhone;
        private Button btnAdd;


    private static final String ARG_P1 = "p1";
    private static final String ARG_P2 = "p2";

    private String mParam1;
    private String mParam2;
        private ImageView img;
        private Utils utils;

        public AddTravilingFragment() {}
    public static AddTravilingFragment newInstance(String param1, String param2) {
        AddTravilingFragment fragment = new AddTravilingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_P1, param1);
        args.putString(ARG_P2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_P1);
            mParam2 = getArguments().getString(ARG_P2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        connectComponents();

    }
    @SuppressLint("WrongViewCast")
    private void connectComponents() {

        fbs = FirebaseServices.getInstance();
        etName = getView().findViewById(R.id.etTitleAddProductFragment);
        etDescription = getView().findViewById(R.id.etDescAddProductFragment);
        etAddress = getView().findViewById(R.id.etPriceAddProductFragment);
        etPhone = getView().findViewById(R.id.editTextPhone);
        btnAdd = getView().findViewById(R.id.btnSignupLogin);
        img=getView().findViewById(R.id.ivShowAddProduct);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from screen
                String name = etName.getText().toString();
                String description = etDescription.getText().toString();
                String address = etAddress.getText().toString();
                String phone = etPhone.getText().toString();
                fbs = FirebaseServices.getInstance();

                if (name.trim().isEmpty() || description.trim().isEmpty() ||
                        address.trim().isEmpty() || phone.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                Traveling traveling;
                if (fbs.getSelectedImageURL() == null)
                {
                    traveling = new Traveling(name, description, address, phone, "");

                }
                else {
                    traveling = new Traveling(name, description, address, phone, fbs.getSelectedImageURL().toString());
                }
                Task<DocumentReference> travels = fbs.getFire().collection("travels").add(traveling).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // TODO: goto show
                        Toast.makeText(getActivity(), "Successfully added your travel!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // TODO: Restaurant
                        Log.e("Failure AddTravel: ", e.getMessage());
                    }


                    // TODO: add imageview onclicklistener: open gallery


                });

            }
        });
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == GALLERY_REQUEST_CODE && resultCode == getActivity().RESULT_OK && data != null) {
                Uri selectedImageUri = data.getData();
                img.setImageURI(selectedImageUri);
                utils.uploadImage(getActivity(), selectedImageUri);
            }
        }
}