/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable no-undef */
/* eslint-disable react/prop-types */
import React from "react";
import {
  Table,
  TableHeader,
  TableColumn,
  TableBody,
  TableRow,
  TableCell,
  Input,
  Button,
  DropdownTrigger,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  User,
  Pagination,
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  useDisclosure
} from "@nextui-org/react";
import { PlusIcon } from "./icons/PlusIcon";
import { EditIcon } from "./icons/EditIcon";
import { DeleteIcon } from "./icons/DeleteIcon";
/*import { EyeIcon } from "./icons/EyeIcon";*/
import { SearchIcon } from "./icons/SearchIcon";
import { ChevronDownIcon } from "./icons/ChevronDownIcon";

const INITIAL_VISIBLE_COLUMNS = ["id", "name", "mbti", "actions"];

export default function CrudTable() {
  const serverIP = process.env.REACT_APP_SERVERIP;

  const [users, setUsers] = React.useState([]);

  const [currentUser, setCurrentUser] = React.useState();

  const [currentUserName, setCurrentUserName] = React.useState('');
  const [currentUserMBTI, setCurrentUserMBTI] = React.useState('');

  React.useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await fetch(`${serverIP}/usuarios/list`);
      const data = await response.json();
      setUsers(data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  const { isOpen: isAddOpen, onOpen: onAddOpen, onOpenChange: onAddOpenChange} = useDisclosure();

  /*
  const { isOpen: isViewOpen, onOpen: onViewOpen, onOpenChange: onViewOpenChange} = useDisclosure();
  
  function handleModalView(user) {
    setCurrentUser(user);
    onViewOpen();
  }*/

  const { isOpen: isEditOpen, onOpen: onEditOpen, onOpenChange: onEditOpenChange} = useDisclosure();

  function handleModalEdit(user) {
    setCurrentUser(user);
    onEditOpen();
  }

  const { isOpen: isDeleteOpen, onOpen: onDeleteOpen, onOpenChange: onDeleteOpenChange} = useDisclosure();

  function handleModalDelete(user) {
    setCurrentUser(user);
    onDeleteOpen();
  }

  const deleteUser = async () => {
    try {
      const response = await fetch(`${serverIP}/usuarios/delete/` + currentUser.id, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        }
      });
      
      if (response.status === 200) {
        console.log("Deleted")
        window.location.reload();
      } 
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  }
  
  const editUser = async (username, mbti) => {
    try {
      const usuarioData = {
        username: username,
        mbti: mbti,
        attitude: currentUser.attitude,
        perception: currentUser.perception,
        orientation: currentUser.orientation,
        behavior: currentUser.behavior
      };

      const response = await fetch(`${serverIP}/usuarios/update/` + currentUser.id, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuarioData)
      });
      
      if (response.status === 200) {
        console.log("Updated")
        window.location.reload();
      } 
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  }

  const createUser = async (username, mbti) => {
    try {
      const usuarioData = {
          username: username,
          mbti: mbti,
          attitude: 0,
          perception: 0,
          orientation: 0,
          behavior: 0
      };

      const response = await fetch(`${serverIP}/usuarios/create`, {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(usuarioData)
      });

      if (response.ok) {
          console.log('User created');
          window.location.reload();
      } else {
          console.error('Failed to save user');
      }
    } catch (error) {
        console.error('Error creating user:', error);
    }
  }

  const columns = [
    { name: "ID", uid: "id", sortable: true },
    { name: "NOMBRE", uid: "name", sortable: true },
    { name: "MBTI", uid: "mbti", sortable: true },
    { name: "ACCIONES", uid: "actions" },
  ];

  const [filterValue, setFilterValue] = React.useState("");
  const [visibleColumns, setVisibleColumns] = React.useState(
    new Set(INITIAL_VISIBLE_COLUMNS)
  );
  const [rowsPerPage, setRowsPerPage] = React.useState(5);
  const [sortDescriptor, setSortDescriptor] = React.useState({
    column: "age",
    direction: "ascending",
  });
  const [page, setPage] = React.useState(1);

  const hasSearchFilter = Boolean(filterValue);

  const headerColumns = React.useMemo(() => {
    if (visibleColumns === "all") return columns;

    return columns.filter((column) =>
      Array.from(visibleColumns).includes(column.uid)
    );
  }, [visibleColumns]);

  const filteredItems = React.useMemo(() => {
    let filteredUsers = [...users];

    if (hasSearchFilter) {
      filteredUsers = filteredUsers.filter((user) =>
        user.username.toLowerCase().includes(filterValue.toLowerCase())
      );
    }

    return filteredUsers;
  }, [users, filterValue]);

  const pages = Math.ceil(filteredItems.length / rowsPerPage);

  const items = React.useMemo(() => {
    const start = (page - 1) * rowsPerPage;
    const end = start + rowsPerPage;

    return filteredItems.slice(start, end);
  }, [page, filteredItems, rowsPerPage]);

  const sortedItems = React.useMemo(() => {
    return [...items].sort((a, b) => {
      const first = a[sortDescriptor.column];
      const second = b[sortDescriptor.column];
      const cmp = first < second ? -1 : first > second ? 1 : 0;

      return sortDescriptor.direction === "descending" ? -cmp : cmp;
    });
  }, [sortDescriptor, items]);

  const renderCell = React.useCallback((user, columnKey) => {
    const cellValue = user[columnKey];

    switch (columnKey) {
      case "name":
        return (
          <User
            avatarProps={{ radius: "lg", src: user.avatar }}
            name={user.username}
          ></User>
        );
      case "role":
        return (
          <div className="flex flex-col">
            <p className="text-bold text-small capitalize">{cellValue}</p>
            <p className="text-bold text-tiny capitalize text-default-400">
              {user.team}
            </p>
          </div>
        );
      case "actions":
        return (
          <div className="relative flex items-center gap-2">
            {/*
            <span
              className="text-lg text-default-400 cursor-pointer active:opacity-50"
              onClick={() => handleModalView(user)}
            >
              <EyeIcon />
            </span>
            */}
            <span
              className="text-lg text-default-400 cursor-pointer active:opacity-50"
              onClick={() => handleModalEdit(user)}
            >
              <EditIcon />
            </span>
            <span
              className="text-lg text-danger cursor-pointer active:opacity-50"
            >
              <DeleteIcon onClick={() => handleModalDelete(user)} />
            </span>
          </div>
        );
      default:
        return cellValue;
    }
  }, []);

  const onNextPage = React.useCallback(() => {
    if (page < pages) {
      setPage(page + 1);
    }
  }, [page, pages]);

  const onPreviousPage = React.useCallback(() => {
    if (page > 1) {
      setPage(page - 1);
    }
  }, [page]);

  const onRowsPerPageChange = React.useCallback((e) => {
    setRowsPerPage(Number(e.target.value));
    setPage(1);
  }, []);

  const onSearchChange = React.useCallback((value) => {
    if (value) {
      setFilterValue(value);
      setPage(1);
    } else {
      setFilterValue("");
    }
  }, []);

  const onClear = React.useCallback(() => {
    setFilterValue("");
    setPage(1);
  }, []);

  function capitalize(str) {
    return str.charAt(0).toUpperCase() + str.slice(1);
  }

  const topContent = React.useMemo(() => {
    return (
      <div className="flex flex-col gap-4">
        <div className="flex justify-between gap-3 items-end">
          <Input
            isClearable
            className="w-full sm:max-w-[44%]"
            placeholder="Buscar por nombre..."
            startContent={<SearchIcon />}
            value={filterValue}
            onClear={() => onClear()}
            onValueChange={onSearchChange}
          />
          <div className="flex gap-3">
            <Dropdown>
              <DropdownTrigger className="hidden sm:flex">
                <Button
                  endContent={<ChevronDownIcon className="text-small" />}
                  variant="flat"
                >
                  Columnas
                </Button>
              </DropdownTrigger>
              <DropdownMenu
                disallowEmptySelection
                aria-label="Table Columns"
                closeOnSelect={false}
                selectedKeys={visibleColumns}
                selectionMode="multiple"
                onSelectionChange={setVisibleColumns}
              >
                {columns.map((column) => (
                  <DropdownItem key={column.uid} className="capitalize">
                    {capitalize(column.name)}
                  </DropdownItem>
                ))}
              </DropdownMenu>
            </Dropdown>
            <Button color="primary" endContent={<PlusIcon />} onPress={onAddOpen} >
              Crear Nuevo
            </Button>
          </div>
        </div>
        <div className="flex justify-between items-center">
          <span className="text-default-400 text-small">
            Total: {users.length} usuarios
          </span>
          <label className="flex items-center text-default-400 text-small">
            Filas por pagina:
            <select
              className="bg-transparent outline-none text-default-400 text-small"
              onChange={onRowsPerPageChange}
            >
              <option value="5">5</option>
              <option value="10">10</option>
              <option value="15">15</option>
            </select>
          </label>
        </div>
      </div>
    );
  }, [
    filterValue,
    visibleColumns,
    onRowsPerPageChange,
    users.length,
    onSearchChange,
    hasSearchFilter,
  ]);

  const bottomContent = React.useMemo(() => {
    return (
      <div className="py-2 px-2 flex justify-between items-center">
        <Pagination
          isCompact
          showControls
          showShadow
          color="primary"
          page={page}
          total={pages}
          onChange={setPage}
        />
        <div className="hidden sm:flex w-[30%] justify-end gap-2">
          <Button
            isDisabled={pages === 1}
            size="sm"
            variant="flat"
            onPress={onPreviousPage}
          >
            Anterior
          </Button>
          <Button
            isDisabled={pages === 1}
            size="sm"
            variant="flat"
            onPress={onNextPage}
          >
            Siguiente
          </Button>
        </div>
      </div>
    );
  }, [items.length, page, pages, hasSearchFilter]);

  return (
    <>
      <Modal isOpen={isAddOpen} onOpenChange={onAddOpenChange} className="dark text-foreground">
        <ModalContent>
          {(onClose) => (
            <>
              <ModalHeader className="flex flex-col gap-1">Agregar nuevo</ModalHeader>
              <ModalBody>
                <Input
                  autoFocus
                  label="Nombre"
                  placeholder="Persona"
                  variant="bordered"
                  value={currentUserName}
                  onValueChange={setCurrentUserName}
                />
                <Input
                  label="MBTI"
                  placeholder="ESFP"
                  variant="bordered"
                  value={currentUserMBTI}
                  onValueChange={setCurrentUserMBTI}
                />
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="flat" onPress={onClose}>
                  Cancelar
                </Button>
                <Button color="primary" onPress={() => createUser(currentUserName, currentUserMBTI)}>
                  Crear
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
      <Modal isOpen={isDeleteOpen} onOpenChange={onDeleteOpenChange} className="dark text-foreground">
        <ModalContent>
          {(onClose) => (
            <>
              <ModalHeader className="flex flex-col gap-1">Borrar registro</ModalHeader>
              <ModalBody>
                <p> 
                  Borrarás al usuario {currentUser.username}, ¿estas seguro?
                </p>
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="light" onPress={onClose}>
                  Cancelar
                </Button>
                <Button color="danger" onPress={() => deleteUser()}>
                  Aceptar
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
      <Modal isOpen={isEditOpen} onOpenChange={onEditOpenChange} className="dark text-foreground">
        <ModalContent>
          {(onClose) => (
            <>
              <ModalHeader className="flex flex-col gap-1">Modificar</ModalHeader>
              <ModalBody>
                <Input
                  autoFocus
                  label="Nombre"
                  placeholder={currentUser.username}
                  variant="bordered"
                  value={currentUserName}
                  onValueChange={setCurrentUserName}
                />
                <Input
                  label="MBTI"
                  placeholder={currentUser.mbti}
                  variant="bordered"
                  value={currentUserMBTI}
                  onValueChange={setCurrentUserMBTI}
                />
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="flat" onPress={onClose}>
                  Cancelar
                </Button>
                <Button color="primary" onPress={() => editUser(currentUserName, currentUserMBTI)}>
                  Guardar
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
      <Table
        aria-label="Example table with custom cells, pagination and sorting"
        isHeaderSticky
        bottomContent={bottomContent}
        bottomContentPlacement="outside"
        classNames={{
          wrapper: "max-h-[382px]",
        }}
        sortDescriptor={sortDescriptor}
        topContent={topContent}
        topContentPlacement="outside"
        onSortChange={setSortDescriptor}
      >
        <TableHeader columns={headerColumns}>
          {(column) => (
            <TableColumn
              key={column.uid}
              align={column.uid === "actions" ? "center" : "start"}
              allowsSorting={column.sortable}
            >
              {column.name}
            </TableColumn>
          )}
        </TableHeader>
        <TableBody emptyContent={"No hay usuarios"} items={sortedItems}>
          {(item) => (
            <TableRow key={item.id}>
              {(columnKey) => (
                <TableCell>{renderCell(item, columnKey)}</TableCell>
              )}
            </TableRow>
          )}
        </TableBody>
      </Table>
    </>
  );
}
