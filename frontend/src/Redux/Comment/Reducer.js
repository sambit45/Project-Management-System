import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  comments: [],
  loading: false,
  error: null,
};

const commentSlice = createSlice({
  name: "comments",
  initialState,
  reducers: {
    createCommentRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    deleteCommentRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchCommentsRequest: (state) => {
      state.loading = true;
      state.error = null;
    },

    createCommentSuccess: (state, action) => {
      state.loading = false;
      state.comments.push(action.payload);
    },
    deleteCommentSuccess: (state, action) => {
      state.loading = false;
      state.comments = state.comments.filter(
        (comment) => comment.id !== action.payload
      );
    },
    fetchCommentsSuccess: (state, action) => {
      state.loading = false;
      state.comments = action.payload;
    },

    createCommentFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
    deleteCommentFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
    fetchCommentsFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const {
  createCommentRequest,
  deleteCommentRequest,
  fetchCommentsRequest,
  createCommentSuccess,
  deleteCommentSuccess,
  fetchCommentsSuccess,
  createCommentFailure,
  deleteCommentFailure,
  fetchCommentsFailure,
} = commentSlice.actions;

export const commentReducer = commentSlice.reducer;
