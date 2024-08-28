import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  messages: [],
  loading: false,
  error: null,
  chat: null,
};

const chatSlice = createSlice({
  name: 'chat',
  initialState,
  reducers: {
    fetchMessageRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    sendMessageRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchChatMessagesRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchMessageSuccess: (state, action) => {
      state.loading = false;
      state.chat = action.payload;
    },
    fetchChatMessagesSuccess: (state, action) => {
      state.loading = false;
      state.chat = action.payload;
    },
    fetchMessageFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
    sendMessageFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
    fetchChatMessagesFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const {
  fetchMessageRequest,
  sendMessageRequest,
  fetchChatMessagesRequest,
  fetchMessageSuccess,
  fetchChatMessagesSuccess,
  fetchMessageFailure,
  sendMessageFailure,
  fetchChatMessagesFailure,
} = chatSlice.actions;

export const chatReducer = chatSlice.reducer;
