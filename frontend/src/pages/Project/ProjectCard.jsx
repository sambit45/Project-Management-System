import { Button } from '@/components/ui/button';
import { Card } from '@/components/ui/card';
import {  DropdownMenuItem, DropdownMenuTrigger } from '@/components/ui/dropdown-menu';
import { DropdownMenu, DropdownMenuContent } from '@radix-ui/react-dropdown-menu';
import { DotFilledIcon, DotsVerticalIcon } from '@radix-ui/react-icons';
import React from 'react'

const ProjectCard = () => {
  return (
    <Card className="p-5 w-full lg:max-w-3xl">
      <div className='space-y-2'>
        <div className='flex justify-between'>
          <div className='flex items-center gap-5'>
            <h1 className='cursor-pointer font-bold text-lg'>
              Create ecommerce project
            </h1>
            <DotFilledIcon/>
            <p className='text-sm text-gray-400'>fullstack</p>
          </div>
          <div>
            <DropdownMenu>
              <DropdownMenuTrigger>
                <Button className="rounded-full" variant="ghost" size="icon">
                  <DotsVerticalIcon/>
                </Button>
              </DropdownMenuTrigger>

              <DropdownMenuContent>
                <DropdownMenuItem>
                    Update
                  </DropdownMenuItem>
                  <DropdownMenuItem>
                    Delete
                  </DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>
          </div>

        </div>
      </div>
    </Card>
  )
}

export default ProjectCard;
