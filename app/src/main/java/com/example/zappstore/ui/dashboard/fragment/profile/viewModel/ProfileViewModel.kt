package com.example.zappstore.ui.dashboard.fragment.profile.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zappstore.model.User
import com.example.zappstore.util.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val firestore : FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
):ViewModel() {

    private val _getUser = MutableStateFlow<Resource<List<User>>>(Resource.Unspecified())
    val getUser: StateFlow<Resource<List<User>>> = _getUser

    init {
        getUserFromDatabase()
    }

    private fun getUserFromDatabase() {
        viewModelScope.launch {
            _getUser.value = Resource.Loading()
        }
        firestore.collection("user")
            .whereEqualTo("email",firebaseAuth.currentUser?.email)
            .get()
            .addOnSuccessListener { result ->
                val user = result.toObjects(User::class.java)
                viewModelScope.launch {
                    _getUser.emit(Resource.Success(user))
                }
            }
            .addOnFailureListener{
                Log.e("User Data", it.message.toString())
            }
    }
}