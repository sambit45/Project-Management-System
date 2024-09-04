import { createSlice } from "@reduxjs/toolkit";
import {
  assignedUserToIssue,
  createIssue,
  fetchIssueById,
  fetchIssues,
  updateIssueStatus,
} from "./Action";

const initialState = {
  issues: [],
  loading: false,
  error: null,
};

const issueSlice = createSlice({
  name: "issues",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(createIssue.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(createIssue.fulfilled, (state, action) => {
        state.loading = false;
        state.issues.push(action.payload);
      })
      .addCase(createIssue.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })
      .addCase(fetchIssues.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchIssues.fulfilled, (state, action) => {
        state.loading = false;
        state.issues = action.payload;
      })
      .addCase(fetchIssues.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })

      .addCase(fetchIssueById.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchIssueById.fulfilled, (state, action) => {
        state.loading = false;
        state.issues = action.payload;
      })
      .addCase(fetchIssueById.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })

      .addCase(updateIssueStatus.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(updateIssueStatus.fulfilled, (state, action) => {
        state.loading = false;
        state.issues = state.issues.map((issue) =>
          issue.id === action.payload.id ? action.payload : issue
        );
      })
      .addCase(updateIssueStatus.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })

      .addCase(assignedUserToIssue.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(assignedUserToIssue.fulfilled, (state, action) => {
        state.loading = false;
        state.issues = state.issues.map((issue) =>
          issue.id === action.payload.id ? action.payload : issue
        );
      })
      .addCase(assignedUserToIssue.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      });
  },
});

export const issueReducer = issueSlice.reducer;
