import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { TrashIcon } from "@radix-ui/react-icons";

const CommentCard = ({item}) => {
  console.log("From comment card",item);
  
  return (
    <div className="flex justify-between ">
      <div className="flex items-center gap-4">
        <Avatar>
          <AvatarFallback>S</AvatarFallback>
        </Avatar>
        <div className="space-y-1">
          <p>Sambit</p>
          <p>{item.content}</p>
        </div>
        <Button className="rounded-full" variant="ghost" size="icon">
          <TrashIcon />
        </Button>
      </div>
    </div>
  );
};

export default CommentCard;
