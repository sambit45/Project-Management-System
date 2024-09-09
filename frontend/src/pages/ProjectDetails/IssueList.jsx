import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import IssueCard from "./IssueCard";
import { Button } from "@/components/ui/button";
import { PlusIcon } from "@radix-ui/react-icons";
import CreateIssueForm from "./CreateIssueForm";
import { useDispatch, useSelector } from "react-redux";
import { fetchIssues } from "@/Redux/Issue/Action";
import { useParams } from "react-router-dom";
import { useEffect } from "react";

const IssueList = ({ title, status }) => {
  const dispatch = useDispatch();
  const { id } = useParams();

  const {issues} = useSelector((store) => store.issue);
  

  useEffect(() => {
    dispatch(fetchIssues(id));
  }, [id, dispatch]);

  return (
    <div>
      <Dialog>
        <Card className="w-full md:w-[300px] lg:w-[310px]">
          <CardHeader>
            <CardTitle>{title}</CardTitle>
          </CardHeader>
          <CardContent>
            <div className="space-y-2">
              {issues?.filter((issue)=>issue.status==status).map((item) => (
                <IssueCard item={item} projectID={id} key={item.id} />
              ))}
            </div>
          </CardContent>
          <CardFooter>
            <DialogTrigger>
              <Button
                variant="outline"
                className="w-full flex items-center gap-2"
              >
                <PlusIcon />
                Create Issue
              </Button>
            </DialogTrigger>
          </CardFooter>
        </Card>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Create New Issue</DialogTitle>
          </DialogHeader>
          <CreateIssueForm status={status}/>
        </DialogContent>
      </Dialog>
    </div>
  );
};

export default IssueList;
